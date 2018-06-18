## Janus Transformation Language (JTL)
Framework implementation for the Eclipse Platform: [jtl.di.univaq.it](https://jtl.di.univaq.it/)

### Download and installation instructions
The JTL Eclipse Product can be downloaded from the [releases page](https://github.com/MDEGroup/jtl-eclipse/releases). [Last](https://github.com/MDEGroup/jtl-eclipse/releases/latest) as well as previous releases can be found on the same page. Release notes are attached to each release.
Once downloaded, the package does not need any installation procedure. It can be extracted anywhere and launched using the `JTL` executable.

### System requirements
JTL is available for Linux, MacOS and Windows. The only requirement is an updated Java version (at least [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)).

**Only on MacOS**
If you get the error *Library not loaded: /usr/local/lib/libltdl.7.dylib*:
```
$ brew install libtool --universal
$ brew link libtool
```

### Upgrading
New releases can be used with old projects and workspaces. An [update site](https://raw.githubusercontent.com/MDEGroup/jtl-eclipse-update-site/master/) is available and already configured in the product to perform updates without downloading again the entire package.

### License information
JTL is distributed under the [Eclipse Public License - v 2.0](https://www.eclipse.org/legal/epl-v20.html)

### Support
Tutorials, case studies and examples can be found at [jtl.di.univaq.it](https://jtl.di.univaq.it). To obtain support one can create a new issue on the [github repository](https://github.com/MDEGroup/jtl-eclipse/issues).

### Getting started
The best way to getting started is by following the [tutorial](https://jtl.di.univaq.it/tutorial.html). Some benchmarks and case studies can be found [here](https://jtl.di.univaq.it/application1.html).

Additional information like research pubblications and applications involving JTL can be found at [jtl.di.univaq.it](https://jtl.di.univaq.it/).

---

#### Organization of components in the source tree

`JTL.emftext.ASPMM`,  
`ASPMM.resource.aspmm`,  
`ASPMM.resource.aspmm.ui`:  
Serialization (encoding) of Ecore Metamodels to ASP facts and unserialization (decoding) of ASP facts to Ecore Metamodels.

`JTL.emftext.ASPM`,  
`ASPM.resource.aspm`,  
`ASPM.resource.aspm.ui`:  
Serialization (encoding) of Ecore Models to ASP facts and unserialization (decoding) of ASP facts to Ecore Models.

`JTL.emftext.ASPT`,  
`ASPT.resource.aspt`,  
`ASPT.resource.aspt.ui`:  
Serialization (encoding) of Ecore Trace Models to ASP facts and unserialization (decoding) of ASP facts to Ecore Trace Models.

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
ATL semantic anchoring from Ecore JTL Programs to Ecore ASP Programs.

`JTL`:  
ASP-based transformation engine.

`JTL.eclipse`:  
OSGi Eclipse Equinox integration plug-in.
