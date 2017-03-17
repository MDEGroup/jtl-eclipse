/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.mopp;

/**
 * The JtlTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class JtlTokenResolverFactory implements JTL.resource.jtl.IJtlTokenResolverFactory {
	
	private java.util.Map<String, JTL.resource.jtl.IJtlTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, JTL.resource.jtl.IJtlTokenResolver> featureName2CollectInTokenResolver;
	private static JTL.resource.jtl.IJtlTokenResolver defaultResolver = new JTL.resource.jtl.analysis.JtlDefaultTokenResolver();
	
	public JtlTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, JTL.resource.jtl.IJtlTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, JTL.resource.jtl.IJtlTokenResolver>();
		registerTokenResolver("TEXT", new JTL.resource.jtl.analysis.JtlTEXTTokenResolver());
	}
	
	public JTL.resource.jtl.IJtlTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public JTL.resource.jtl.IJtlTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, JTL.resource.jtl.IJtlTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, JTL.resource.jtl.IJtlTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected JTL.resource.jtl.IJtlTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private JTL.resource.jtl.IJtlTokenResolver internalCreateResolver(java.util.Map<String, JTL.resource.jtl.IJtlTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, JTL.resource.jtl.IJtlTokenResolver> resolverMap, String key, JTL.resource.jtl.IJtlTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
