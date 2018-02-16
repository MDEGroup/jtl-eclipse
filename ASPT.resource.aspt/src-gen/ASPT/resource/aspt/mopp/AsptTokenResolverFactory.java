/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.mopp;

/**
 * The AsptTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class AsptTokenResolverFactory implements ASPT.resource.aspt.IAsptTokenResolverFactory {
	
	private java.util.Map<String, ASPT.resource.aspt.IAsptTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, ASPT.resource.aspt.IAsptTokenResolver> featureName2CollectInTokenResolver;
	private static ASPT.resource.aspt.IAsptTokenResolver defaultResolver = new ASPT.resource.aspt.analysis.AsptDefaultTokenResolver();
	
	public AsptTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, ASPT.resource.aspt.IAsptTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, ASPT.resource.aspt.IAsptTokenResolver>();
		registerTokenResolver("IDENTIFIER", new ASPT.resource.aspt.analysis.AsptIDENTIFIERTokenResolver());
		registerTokenResolver("INTEGER", new ASPT.resource.aspt.analysis.AsptINTEGERTokenResolver());
		registerTokenResolver("QUOTED_34_34", new ASPT.resource.aspt.analysis.AsptQUOTED_34_34TokenResolver());
	}
	
	public ASPT.resource.aspt.IAsptTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public ASPT.resource.aspt.IAsptTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, ASPT.resource.aspt.IAsptTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, ASPT.resource.aspt.IAsptTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected ASPT.resource.aspt.IAsptTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private ASPT.resource.aspt.IAsptTokenResolver internalCreateResolver(java.util.Map<String, ASPT.resource.aspt.IAsptTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, ASPT.resource.aspt.IAsptTokenResolver> resolverMap, String key, ASPT.resource.aspt.IAsptTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
