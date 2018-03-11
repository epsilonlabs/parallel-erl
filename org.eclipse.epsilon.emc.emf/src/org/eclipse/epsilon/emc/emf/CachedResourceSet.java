package org.eclipse.epsilon.emc.emf;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class CachedResourceSet extends ResourceSetImpl {
	
	protected static final Cache cache = new Cache();
	
	public static Cache getCache() {
		return cache;
	}
	@Override
	public Resource createResource(URI uri, String contentType) {
		Resource cachedResource = getCache().checkoutResource(uri);
		if (cachedResource == null) {
			cachedResource = createNewResource(uri, contentType);
			cachedResource.setTrackingModification(false);
			if (cachedResource instanceof XMLResource) {
				configure((XMLResource) cachedResource);
			}
			getResources().add(cachedResource);
			getCache().cacheResource(uri, cachedResource);
		}
		return cachedResource;
	}
	
	public Resource createNewResource(URI uri, String contentType) {
		Resource resource = super.createResource(uri, contentType);
		if (resource == null) {
			resource = new XMIResourceFactoryImpl().createResource(uri);
		}
		return resource;
	}
	
	public void configure(XMLResource resource) {
		Map<Object, Object> loadOptions = resource.getDefaultLoadOptions();
		//loadOptions.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
		//loadOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
	}

	public static class Cache {
		
		protected Collection<CacheItem> items = new ConcurrentLinkedQueue<>();
		
		public void cacheResource(URI uri, Resource resource) {
			CacheItem item = new CacheItem();
			item.setUri(uri);
			item.setResource(resource);
			item.incrementCheckedOut();
			items.add(item);
		}
		
		public boolean isCached(URI uri) {
			for (CacheItem item : items) {
				if (item.getUri().equals(uri)) return item.getResource() != null;
			}
			return false;
		}
		
		public Resource checkoutResource(URI uri) {
			CacheItem toCheckout = null;
			for (CacheItem item : items) {
				if (item.getUri().equals(uri)) {
					toCheckout = item;
					break;
				}
			}
			
			if (toCheckout == null) {
				return null;
			}
			else if (toCheckout.getResource() != null) {
				toCheckout.incrementCheckedOut();
				return toCheckout.getResource();
			}
			else {
				items.remove(toCheckout);
				return null;
			}
		}
		
		public void returnResource(Resource resource) {
			CacheItem toReturn = null;
			for (CacheItem item : items) {
				if (resource.equals(item.getResource())) {
					toReturn = item;
					break;
				}
			}
			
			if (toReturn != null) {
				toReturn.decrementCheckedOut();
				if (toReturn.getCheckedOut() == 0) {
					items.remove(toReturn);

					/*
					 * Explicitly unload the resource - needed to avoid leaks in
					 * UML models, which keep their own cache.
					 */
					resource.unload();
				}
			}
		}
		
		public void clear() {
			items.clear();
		}
		
		public int size() {
			return items.size();
		}
		
		public Collection<CacheItem> getItems() {
			return items;
		}
		
		public class CacheItem {
			protected WeakReference<Resource> resourceReference;
			public URI uri;
			public int checkedOut = 0;
			
			public Resource getResource() {
				return resourceReference.get();
			}
			
			public void setResource(Resource resource) {
				resourceReference = new WeakReference<Resource>(resource);
			}
			
			public void setUri(URI uri) {
				this.uri = uri;
			}
			
			public URI getUri() {
				return uri;
			}
			
			public void incrementCheckedOut() {
				checkedOut ++;
			}
			
			public void decrementCheckedOut() {
				checkedOut--;
			}
			
			public int getCheckedOut() {
				return checkedOut;
			}
		}
	}
}
