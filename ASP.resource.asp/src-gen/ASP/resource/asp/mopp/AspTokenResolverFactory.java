/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.mopp;

/**
 * The AspTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class AspTokenResolverFactory implements ASP.resource.asp.IAspTokenResolverFactory {
	
	private java.util.Map<String, ASP.resource.asp.IAspTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, ASP.resource.asp.IAspTokenResolver> featureName2CollectInTokenResolver;
	private static ASP.resource.asp.IAspTokenResolver defaultResolver = new ASP.resource.asp.analysis.AspDefaultTokenResolver();
	
	public AspTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, ASP.resource.asp.IAspTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, ASP.resource.asp.IAspTokenResolver>();
		registerTokenResolver("TEXT", new ASP.resource.asp.analysis.AspTEXTTokenResolver());
		registerTokenResolver("QUOTED_40_41", new ASP.resource.asp.analysis.AspQUOTED_40_41TokenResolver());
	}
	
	public ASP.resource.asp.IAspTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public ASP.resource.asp.IAspTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, ASP.resource.asp.IAspTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, ASP.resource.asp.IAspTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected ASP.resource.asp.IAspTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private ASP.resource.asp.IAspTokenResolver internalCreateResolver(java.util.Map<String, ASP.resource.asp.IAspTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, ASP.resource.asp.IAspTokenResolver> resolverMap, String key, ASP.resource.asp.IAspTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
