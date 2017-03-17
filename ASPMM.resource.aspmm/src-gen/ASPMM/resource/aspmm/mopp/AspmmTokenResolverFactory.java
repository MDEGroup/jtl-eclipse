/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.mopp;

/**
 * The AspmmTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class AspmmTokenResolverFactory implements ASPMM.resource.aspmm.IAspmmTokenResolverFactory {
	
	private java.util.Map<String, ASPMM.resource.aspmm.IAspmmTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, ASPMM.resource.aspmm.IAspmmTokenResolver> featureName2CollectInTokenResolver;
	private static ASPMM.resource.aspmm.IAspmmTokenResolver defaultResolver = new ASPMM.resource.aspmm.analysis.AspmmDefaultTokenResolver();
	
	public AspmmTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, ASPMM.resource.aspmm.IAspmmTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, ASPMM.resource.aspmm.IAspmmTokenResolver>();
		registerTokenResolver("TEXT", new ASPMM.resource.aspmm.analysis.AspmmTEXTTokenResolver());
	}
	
	public ASPMM.resource.aspmm.IAspmmTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public ASPMM.resource.aspmm.IAspmmTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, ASPMM.resource.aspmm.IAspmmTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, ASPMM.resource.aspmm.IAspmmTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected ASPMM.resource.aspmm.IAspmmTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private ASPMM.resource.aspmm.IAspmmTokenResolver internalCreateResolver(java.util.Map<String, ASPMM.resource.aspmm.IAspmmTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, ASPMM.resource.aspmm.IAspmmTokenResolver> resolverMap, String key, ASPMM.resource.aspmm.IAspmmTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
