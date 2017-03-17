### Janus Transformation Language (JTL)
##### Framework implementation for the Eclipse Platform.
http://jtl.di.univaq.it/

Components:

`JTL.emftext.ASPMM`,  
`ASPMM.resource.aspmm`,  
`ASPMM.resource.aspmm.ui`:  
Serialization (encoding) of Ecore Metamodels to ASP facts and unserialization (decoding) of ASP facts to Ecore Models.

`JTL.emftext.ASPM`,  
`ASPM.resource.aspm`,  
`ASPM.resource.aspm.ui`:  
Serialization (encoding) of Ecore Models to ASP facts and unserialization (decoding) of ASP facts to Ecore Models.

`JTL.emftext.JTL`,  
`JTL.resource.jtl`,  
`JTL.resource.jtl.ui`:  
Mapping of JTL Programs (text) to Ecore JTL Programs (and viceversa).

`JTL.emftext.ASP`,  
`ASP.resource.asp`,  
`ASP.resource.asp.ui`:  
Mapping of Ecore ASP programs to ASP programs (text) (and viceversa).

`org.emftext.commons.antlr3_4_0`:  
ANTLR framework implementation to integrate with EMFText.

`JTL.atl`:  
ATL Semantic anchoring from Ecore JTL Programs to Ecore ASP Programs.

`JTL`:  
ASP-based transformation engine and OSGi Eclipse Equinox integration plug-in.
