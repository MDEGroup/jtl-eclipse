// $ANTLR 3.4

	package ASPT.resource.aspt.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AsptParser extends AsptANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LINEBREAK", "QUOTED_34_34_92", "TEXT", "WHITESPACE", "'('", "')'", "','", "'.'", "'trace_edge'", "'trace_link'", "'trace_model'", "'trace_nb_edge'", "'trace_nb_node'", "'trace_nb_prop'", "'trace_node'", "'trace_prop'"
    };

    public static final int EOF=-1;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int LINEBREAK=4;
    public static final int QUOTED_34_34_92=5;
    public static final int TEXT=6;
    public static final int WHITESPACE=7;

    // delegates
    public AsptANTLRParserBase[] getDelegates() {
        return new AsptANTLRParserBase[] {};
    }

    // delegators


    public AsptParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public AsptParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(21 + 1);
         

    }

    public String[] getTokenNames() { return AsptParser.tokenNames; }
    public String getGrammarFileName() { return "Aspt.g"; }


    	private ASPT.resource.aspt.IAsptTokenResolverFactory tokenResolverFactory = new ASPT.resource.aspt.mopp.AsptTokenResolverFactory();
    	
    	/**
    	 * the index of the last token that was handled by collectHiddenTokens()
    	 */
    	private int lastPosition;
    	
    	/**
    	 * A flag that indicates whether the parser should remember all expected elements.
    	 * This flag is set to true when using the parse for code completion. Otherwise it
    	 * is set to false.
    	 */
    	private boolean rememberExpectedElements = false;
    	
    	private Object parseToIndexTypeObject;
    	private int lastTokenIndex = 0;
    	
    	/**
    	 * A list of expected elements the were collected while parsing the input stream.
    	 * This list is only filled if <code>rememberExpectedElements</code> is set to
    	 * true.
    	 */
    	private java.util.List<ASPT.resource.aspt.mopp.AsptExpectedTerminal> expectedElements = new java.util.ArrayList<ASPT.resource.aspt.mopp.AsptExpectedTerminal>();
    	
    	private int mismatchedTokenRecoveryTries = 0;
    	/**
    	 * A helper list to allow a lexer to pass errors to its parser
    	 */
    	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
    	
    	/**
    	 * Another helper list to allow a lexer to pass positions of errors to its parser
    	 */
    	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
    	
    	/**
    	 * A stack for incomplete objects. This stack is used filled when the parser is
    	 * used for code completion. Whenever the parser starts to read an object it is
    	 * pushed on the stack. Once the element was parser completely it is popped from
    	 * the stack.
    	 */
    	java.util.List<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
    	
    	private int stopIncludingHiddenTokens;
    	private int stopExcludingHiddenTokens;
    	private int tokenIndexOfLastCompleteElement;
    	
    	private int expectedElementsIndexOfLastCompleteElement;
    	
    	/**
    	 * The offset indicating the cursor position when the parser is used for code
    	 * completion by calling parseToExpectedElements().
    	 */
    	private int cursorOffset;
    	
    	/**
    	 * The offset of the first hidden token of the last expected element. This offset
    	 * is used to discard expected elements, which are not needed for code completion.
    	 */
    	private int lastStartIncludingHidden;
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new ASPT.resource.aspt.IAsptCommand<ASPT.resource.aspt.IAsptTextResource>() {
    			public boolean execute(ASPT.resource.aspt.IAsptTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new ASPT.resource.aspt.IAsptProblem() {
    					public ASPT.resource.aspt.AsptEProblemSeverity getSeverity() {
    						return ASPT.resource.aspt.AsptEProblemSeverity.ERROR;
    					}
    					public ASPT.resource.aspt.AsptEProblemType getType() {
    						return ASPT.resource.aspt.AsptEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<ASPT.resource.aspt.IAsptQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	public void addExpectedElement(org.eclipse.emf.ecore.EClass eClass, int[] ids) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		int terminalID = ids[0];
    		int followSetID = ids[1];
    		ASPT.resource.aspt.IAsptExpectedElement terminal = ASPT.resource.aspt.grammar.AsptFollowSetProvider.TERMINALS[terminalID];
    		ASPT.resource.aspt.mopp.AsptContainedFeature[] containmentFeatures = new ASPT.resource.aspt.mopp.AsptContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = ASPT.resource.aspt.grammar.AsptFollowSetProvider.LINKS[ids[i]];
    		}
    		ASPT.resource.aspt.grammar.AsptContainmentTrace containmentTrace = new ASPT.resource.aspt.grammar.AsptContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		ASPT.resource.aspt.mopp.AsptExpectedTerminal expectedElement = new ASPT.resource.aspt.mopp.AsptExpectedTerminal(container, terminal, followSetID, containmentTrace);
    		setPosition(expectedElement, input.index());
    		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
    		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
    			// clear list of expected elements
    			this.expectedElements.clear();
    			this.expectedElementsIndexOfLastCompleteElement = 0;
    		}
    		lastStartIncludingHidden = startIncludingHiddenTokens;
    		this.expectedElements.add(expectedElement);
    	}
    	
    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
    	}
    	
    	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new ASPT.resource.aspt.IAsptCommand<ASPT.resource.aspt.IAsptTextResource>() {
    			public boolean execute(ASPT.resource.aspt.IAsptTextResource resource) {
    				ASPT.resource.aspt.IAsptLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharStart(target, locationMap.getCharStart(source));
    				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
    				locationMap.setColumn(target, locationMap.getColumn(source));
    				locationMap.setLine(target, locationMap.getLine(source));
    				return true;
    			}
    		});
    	}
    	
    	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new ASPT.resource.aspt.IAsptCommand<ASPT.resource.aspt.IAsptTextResource>() {
    			public boolean execute(ASPT.resource.aspt.IAsptTextResource resource) {
    				ASPT.resource.aspt.IAsptLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				if (source == null) {
    					return true;
    				}
    				locationMap.setCharStart(target, source.getStartIndex());
    				locationMap.setCharEnd(target, source.getStopIndex());
    				locationMap.setColumn(target, source.getCharPositionInLine());
    				locationMap.setLine(target, source.getLine());
    				return true;
    			}
    		});
    	}
    	
    	/**
    	 * Sets the end character index and the last line for the given object in the
    	 * location map.
    	 */
    	protected void setLocalizationEnd(java.util.Collection<ASPT.resource.aspt.IAsptCommand<ASPT.resource.aspt.IAsptTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new ASPT.resource.aspt.IAsptCommand<ASPT.resource.aspt.IAsptTextResource>() {
    			public boolean execute(ASPT.resource.aspt.IAsptTextResource resource) {
    				ASPT.resource.aspt.IAsptLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public ASPT.resource.aspt.IAsptTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new AsptParser(new org.antlr.runtime3_4_0.CommonTokenStream(new AsptLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new AsptParser(new org.antlr.runtime3_4_0.CommonTokenStream(new AsptLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new ASPT.resource.aspt.util.AsptRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public AsptParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((AsptLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((AsptLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == ASPT.TraceModel.class) {
    				return parse_ASPT_TraceModel();
    			}
    			if (type.getInstanceClass() == ASPT.TraceNode.class) {
    				return parse_ASPT_TraceNode();
    			}
    			if (type.getInstanceClass() == ASPT.TraceProp.class) {
    				return parse_ASPT_TraceProp();
    			}
    			if (type.getInstanceClass() == ASPT.TraceEdge.class) {
    				return parse_ASPT_TraceEdge();
    			}
    			if (type.getInstanceClass() == ASPT.TraceNbEdge.class) {
    				return parse_ASPT_TraceNbEdge();
    			}
    			if (type.getInstanceClass() == ASPT.TraceNbProp.class) {
    				return parse_ASPT_TraceNbProp();
    			}
    			if (type.getInstanceClass() == ASPT.TraceNbNode.class) {
    				return parse_ASPT_TraceNbNode();
    			}
    			if (type.getInstanceClass() == ASPT.TraceLink.class) {
    				return parse_ASPT_TraceLink();
    			}
    		}
    		throw new ASPT.resource.aspt.mopp.AsptUnexpectedContentTypeException(typeObject);
    	}
    	
    	public int getMismatchedTokenRecoveryTries() {
    		return mismatchedTokenRecoveryTries;
    	}
    	
    	public Object getMissingSymbol(org.antlr.runtime3_4_0.IntStream arg0, org.antlr.runtime3_4_0.RecognitionException arg1, int arg2, org.antlr.runtime3_4_0.BitSet arg3) {
    		mismatchedTokenRecoveryTries++;
    		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
    	}
    	
    	public Object getParseToIndexTypeObject() {
    		return parseToIndexTypeObject;
    	}
    	
    	protected Object getTypeObject() {
    		Object typeObject = getParseToIndexTypeObject();
    		if (typeObject != null) {
    			return typeObject;
    		}
    		java.util.Map<?,?> options = getOptions();
    		if (options != null) {
    			typeObject = options.get(ASPT.resource.aspt.IAsptOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public ASPT.resource.aspt.IAsptParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<ASPT.resource.aspt.IAsptCommand<ASPT.resource.aspt.IAsptTextResource>>();
    		ASPT.resource.aspt.mopp.AsptParseResult parseResult = new ASPT.resource.aspt.mopp.AsptParseResult();
    		try {
    			org.eclipse.emf.ecore.EObject result =  doParse();
    			if (lexerExceptions.isEmpty()) {
    				parseResult.setRoot(result);
    			}
    		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
    			reportError(re);
    		} catch (java.lang.IllegalArgumentException iae) {
    			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
    				// can be caused if a null is set on EMF models where not allowed. this will just
    				// happen if other errors occurred before
    			} else {
    				iae.printStackTrace();
    			}
    		}
    		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
    			reportLexicalError(re);
    		}
    		parseResult.getPostParseCommands().addAll(postParseCommands);
    		return parseResult;
    	}
    	
    	public java.util.List<ASPT.resource.aspt.mopp.AsptExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, ASPT.resource.aspt.IAsptTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		ASPT.resource.aspt.IAsptParseResult result = parse();
    		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
    			org.antlr.runtime3_4_0.Lexer lexer = (org.antlr.runtime3_4_0.Lexer) tokenStream.getTokenSource();
    			int endChar = lexer.getCharIndex();
    			int endLine = lexer.getLine();
    			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
    		}
    		if (result != null) {
    			org.eclipse.emf.ecore.EObject root = result.getRoot();
    			if (root != null) {
    				dummyResource.getContentsInternal().add(root);
    			}
    			for (ASPT.resource.aspt.IAsptCommand<ASPT.resource.aspt.IAsptTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<ASPT.resource.aspt.mopp.AsptExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<ASPT.resource.aspt.mopp.AsptExpectedTerminal>();
    		java.util.List<ASPT.resource.aspt.mopp.AsptExpectedTerminal> newFollowSet = new java.util.ArrayList<ASPT.resource.aspt.mopp.AsptExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			ASPT.resource.aspt.mopp.AsptExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 122;
    		int i;
    		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
    			org.antlr.runtime3_4_0.CommonToken nextToken = (org.antlr.runtime3_4_0.CommonToken) tokenStream.get(i);
    			if (nextToken.getType() < 0) {
    				break;
    			}
    			if (nextToken.getChannel() == 99) {
    				// hidden tokens do not reduce the follow set
    			} else {
    				// now that we have found the next visible token the position for that expected
    				// terminals can be set
    				for (ASPT.resource.aspt.mopp.AsptExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (ASPT.resource.aspt.mopp.AsptExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<ASPT.resource.aspt.util.AsptPair<ASPT.resource.aspt.IAsptExpectedElement, ASPT.resource.aspt.mopp.AsptContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (ASPT.resource.aspt.util.AsptPair<ASPT.resource.aspt.IAsptExpectedElement, ASPT.resource.aspt.mopp.AsptContainedFeature[]> newFollowerPair : newFollowers) {
    							ASPT.resource.aspt.IAsptExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							ASPT.resource.aspt.grammar.AsptContainmentTrace containmentTrace = new ASPT.resource.aspt.grammar.AsptContainmentTrace(null, newFollowerPair.getRight());
    							ASPT.resource.aspt.mopp.AsptExpectedTerminal newFollowTerminal = new ASPT.resource.aspt.mopp.AsptExpectedTerminal(container, newFollower, followSetID, containmentTrace);
    							newFollowSet.add(newFollowTerminal);
    							expectedElements.add(newFollowTerminal);
    						}
    					}
    				}
    				currentFollowSet.clear();
    				currentFollowSet.addAll(newFollowSet);
    			}
    			followSetID++;
    		}
    		// after the last token in the stream we must set the position for the elements
    		// that were added during the last iteration of the loop
    		for (ASPT.resource.aspt.mopp.AsptExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(ASPT.resource.aspt.mopp.AsptExpectedTerminal expectedElement, int tokenIndex) {
    		int currentIndex = Math.max(0, tokenIndex);
    		for (int index = lastTokenIndex; index < currentIndex; index++) {
    			if (index >= input.size()) {
    				break;
    			}
    			org.antlr.runtime3_4_0.CommonToken tokenAtIndex = (org.antlr.runtime3_4_0.CommonToken) input.get(index);
    			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
    				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			}
    		}
    		lastTokenIndex = Math.max(0, currentIndex);
    		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
    	}
    	
    	public Object recoverFromMismatchedToken(org.antlr.runtime3_4_0.IntStream input, int ttype, org.antlr.runtime3_4_0.BitSet follow) throws org.antlr.runtime3_4_0.RecognitionException {
    		if (!rememberExpectedElements) {
    			return super.recoverFromMismatchedToken(input, ttype, follow);
    		} else {
    			return null;
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the parser into human readable messages.
    	 */
    	public void reportError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = e.getMessage();
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			String expectedTokenName = formatTokenName(mte.expecting);
    			String actualTokenName = formatTokenName(e.token.getType());
    			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
    			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
    			String expectedTokenName = formatTokenName(mtne.expecting);
    			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
    		}
    		// the resource may be null if the parser is used for code completion
    		final String finalMessage = message;
    		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
    			final org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
    			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
    		} else {
    			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the lexer into human readable messages.
    	 */
    	public void reportLexicalError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = "";
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			org.antlr.runtime3_4_0.EarlyExitException eee = (org.antlr.runtime3_4_0.EarlyExitException) e;
    			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
    			org.antlr.runtime3_4_0.MismatchedRangeException mre = (org.antlr.runtime3_4_0.MismatchedRangeException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
    		}
    		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
    	}
    	
    	private void startIncompleteElement(Object object) {
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.incompleteObjects.add((org.eclipse.emf.ecore.EObject) object);
    		}
    	}
    	
    	private void completedElement(Object object, boolean isContainment) {
    		if (isContainment && !this.incompleteObjects.isEmpty()) {
    			boolean exists = this.incompleteObjects.remove(object);
    			if (!exists) {
    			}
    		}
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
    			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
    		}
    	}
    	
    	private org.eclipse.emf.ecore.EObject getLastIncompleteElement() {
    		if (incompleteObjects.isEmpty()) {
    			return null;
    		}
    		return incompleteObjects.get(incompleteObjects.size() - 1);
    	}
    	



    // $ANTLR start "start"
    // Aspt.g:520:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_ASPT_TraceModel ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        ASPT.TraceModel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Aspt.g:521:2: ( (c0= parse_ASPT_TraceModel ) EOF )
            // Aspt.g:522:2: (c0= parse_ASPT_TraceModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Aspt.g:527:2: (c0= parse_ASPT_TraceModel )
            // Aspt.g:528:3: c0= parse_ASPT_TraceModel
            {
            pushFollow(FOLLOW_parse_ASPT_TraceModel_in_start82);
            c0=parse_ASPT_TraceModel();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; }

            }


            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		retrieveLayoutInformation(element, null, null, false);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "start"



    // $ANTLR start "parse_ASPT_TraceModel"
    // Aspt.g:536:1: parse_ASPT_TraceModel returns [ASPT.TraceModel element = null] : a0= 'trace_model' a1= '(' (a2= QUOTED_34_34_92 ) a3= ',' (a4= TEXT ) a5= ')' a6= '.' ( ( (a7_0= parse_ASPT_TraceElement ) | (a8_0= parse_ASPT_TraceLink ) ) )* ;
    public final ASPT.TraceModel parse_ASPT_TraceModel() throws RecognitionException {
        ASPT.TraceModel element =  null;

        int parse_ASPT_TraceModel_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        ASPT.TraceElement a7_0 =null;

        ASPT.TraceLink a8_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Aspt.g:539:2: (a0= 'trace_model' a1= '(' (a2= QUOTED_34_34_92 ) a3= ',' (a4= TEXT ) a5= ')' a6= '.' ( ( (a7_0= parse_ASPT_TraceElement ) | (a8_0= parse_ASPT_TraceLink ) ) )* )
            // Aspt.g:540:2: a0= 'trace_model' a1= '(' (a2= QUOTED_34_34_92 ) a3= ',' (a4= TEXT ) a5= ')' a6= '.' ( ( (a7_0= parse_ASPT_TraceElement ) | (a8_0= parse_ASPT_TraceLink ) ) )*
            {
            a0=(Token)match(input,14,FOLLOW_14_in_parse_ASPT_TraceModel115); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[1]);
            	}

            a1=(Token)match(input,8,FOLLOW_8_in_parse_ASPT_TraceModel129); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[2]);
            	}

            // Aspt.g:568:2: (a2= QUOTED_34_34_92 )
            // Aspt.g:569:3: a2= QUOTED_34_34_92
            {
            a2=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceModel147); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__ID), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__ID), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_2, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[3]);
            	}

            a3=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceModel168); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[4]);
            	}

            // Aspt.g:618:2: (a4= TEXT )
            // Aspt.g:619:3: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceModel186); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
            				startIncompleteElement(element);
            			}
            			if (a4 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__MMS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__MMS), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_4, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[5]);
            	}

            a5=(Token)match(input,9,FOLLOW_9_in_parse_ASPT_TraceModel207); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[6]);
            	}

            a6=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceModel221); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[7]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[8]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[10]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[11]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[12]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[13]);
            	}

            // Aspt.g:688:2: ( ( (a7_0= parse_ASPT_TraceElement ) | (a8_0= parse_ASPT_TraceLink ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= 12 && LA2_0 <= 13)||(LA2_0 >= 15 && LA2_0 <= 19)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Aspt.g:689:3: ( (a7_0= parse_ASPT_TraceElement ) | (a8_0= parse_ASPT_TraceLink ) )
            	    {
            	    // Aspt.g:689:3: ( (a7_0= parse_ASPT_TraceElement ) | (a8_0= parse_ASPT_TraceLink ) )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==12||(LA1_0 >= 15 && LA1_0 <= 19)) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==13) ) {
            	        int LA1_2 = input.LA(2);

            	        if ( (LA1_2==8) ) {
            	            int LA1_3 = input.LA(3);

            	            if ( (LA1_3==TEXT) ) {
            	                int LA1_4 = input.LA(4);

            	                if ( (LA1_4==10) ) {
            	                    int LA1_5 = input.LA(5);

            	                    if ( (LA1_5==TEXT) ) {
            	                        int LA1_6 = input.LA(6);

            	                        if ( (LA1_6==10) ) {
            	                            int LA1_7 = input.LA(7);

            	                            if ( (LA1_7==QUOTED_34_34_92) ) {
            	                                int LA1_8 = input.LA(8);

            	                                if ( (LA1_8==10) ) {
            	                                    int LA1_9 = input.LA(9);

            	                                    if ( (LA1_9==TEXT) ) {
            	                                        int LA1_10 = input.LA(10);

            	                                        if ( (LA1_10==10) ) {
            	                                            int LA1_11 = input.LA(11);

            	                                            if ( (LA1_11==QUOTED_34_34_92) ) {
            	                                                int LA1_12 = input.LA(12);

            	                                                if ( (LA1_12==10) ) {
            	                                                    int LA1_13 = input.LA(13);

            	                                                    if ( (LA1_13==TEXT) ) {
            	                                                        int LA1_14 = input.LA(14);

            	                                                        if ( (LA1_14==10) ) {
            	                                                            int LA1_15 = input.LA(15);

            	                                                            if ( (LA1_15==QUOTED_34_34_92) ) {
            	                                                                int LA1_16 = input.LA(16);

            	                                                                if ( (LA1_16==9) ) {
            	                                                                    int LA1_17 = input.LA(17);

            	                                                                    if ( (LA1_17==11) ) {
            	                                                                        int LA1_18 = input.LA(18);

            	                                                                        if ( (synpred1_Aspt()) ) {
            	                                                                            alt1=1;
            	                                                                        }
            	                                                                        else if ( (true) ) {
            	                                                                            alt1=2;
            	                                                                        }
            	                                                                        else {
            	                                                                            if (state.backtracking>0) {state.failed=true; return element;}
            	                                                                            NoViableAltException nvae =
            	                                                                                new NoViableAltException("", 1, 18, input);

            	                                                                            throw nvae;

            	                                                                        }
            	                                                                    }
            	                                                                    else {
            	                                                                        if (state.backtracking>0) {state.failed=true; return element;}
            	                                                                        NoViableAltException nvae =
            	                                                                            new NoViableAltException("", 1, 17, input);

            	                                                                        throw nvae;

            	                                                                    }
            	                                                                }
            	                                                                else {
            	                                                                    if (state.backtracking>0) {state.failed=true; return element;}
            	                                                                    NoViableAltException nvae =
            	                                                                        new NoViableAltException("", 1, 16, input);

            	                                                                    throw nvae;

            	                                                                }
            	                                                            }
            	                                                            else {
            	                                                                if (state.backtracking>0) {state.failed=true; return element;}
            	                                                                NoViableAltException nvae =
            	                                                                    new NoViableAltException("", 1, 15, input);

            	                                                                throw nvae;

            	                                                            }
            	                                                        }
            	                                                        else {
            	                                                            if (state.backtracking>0) {state.failed=true; return element;}
            	                                                            NoViableAltException nvae =
            	                                                                new NoViableAltException("", 1, 14, input);

            	                                                            throw nvae;

            	                                                        }
            	                                                    }
            	                                                    else {
            	                                                        if (state.backtracking>0) {state.failed=true; return element;}
            	                                                        NoViableAltException nvae =
            	                                                            new NoViableAltException("", 1, 13, input);

            	                                                        throw nvae;

            	                                                    }
            	                                                }
            	                                                else {
            	                                                    if (state.backtracking>0) {state.failed=true; return element;}
            	                                                    NoViableAltException nvae =
            	                                                        new NoViableAltException("", 1, 12, input);

            	                                                    throw nvae;

            	                                                }
            	                                            }
            	                                            else {
            	                                                if (state.backtracking>0) {state.failed=true; return element;}
            	                                                NoViableAltException nvae =
            	                                                    new NoViableAltException("", 1, 11, input);

            	                                                throw nvae;

            	                                            }
            	                                        }
            	                                        else {
            	                                            if (state.backtracking>0) {state.failed=true; return element;}
            	                                            NoViableAltException nvae =
            	                                                new NoViableAltException("", 1, 10, input);

            	                                            throw nvae;

            	                                        }
            	                                    }
            	                                    else {
            	                                        if (state.backtracking>0) {state.failed=true; return element;}
            	                                        NoViableAltException nvae =
            	                                            new NoViableAltException("", 1, 9, input);

            	                                        throw nvae;

            	                                    }
            	                                }
            	                                else {
            	                                    if (state.backtracking>0) {state.failed=true; return element;}
            	                                    NoViableAltException nvae =
            	                                        new NoViableAltException("", 1, 8, input);

            	                                    throw nvae;

            	                                }
            	                            }
            	                            else {
            	                                if (state.backtracking>0) {state.failed=true; return element;}
            	                                NoViableAltException nvae =
            	                                    new NoViableAltException("", 1, 7, input);

            	                                throw nvae;

            	                            }
            	                        }
            	                        else {
            	                            if (state.backtracking>0) {state.failed=true; return element;}
            	                            NoViableAltException nvae =
            	                                new NoViableAltException("", 1, 6, input);

            	                            throw nvae;

            	                        }
            	                    }
            	                    else {
            	                        if (state.backtracking>0) {state.failed=true; return element;}
            	                        NoViableAltException nvae =
            	                            new NoViableAltException("", 1, 5, input);

            	                        throw nvae;

            	                    }
            	                }
            	                else {
            	                    if (state.backtracking>0) {state.failed=true; return element;}
            	                    NoViableAltException nvae =
            	                        new NoViableAltException("", 1, 4, input);

            	                    throw nvae;

            	                }
            	            }
            	            else {
            	                if (state.backtracking>0) {state.failed=true; return element;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 1, 3, input);

            	                throw nvae;

            	            }
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return element;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 1, 2, input);

            	            throw nvae;

            	        }
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // Aspt.g:690:4: (a7_0= parse_ASPT_TraceElement )
            	            {
            	            // Aspt.g:690:4: (a7_0= parse_ASPT_TraceElement )
            	            // Aspt.g:691:5: a7_0= parse_ASPT_TraceElement
            	            {
            	            pushFollow(FOLLOW_parse_ASPT_TraceElement_in_parse_ASPT_TraceModel250);
            	            a7_0=parse_ASPT_TraceElement();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a7_0 != null) {
            	            						if (a7_0 != null) {
            	            							Object value = a7_0;
            	            							addObjectToList(element, ASPT.ASPTPackage.TRACE_MODEL__TRACEELEMENTS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_8_0_0_0, a7_0, true);
            	            						copyLocalizationInfos(a7_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[14]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[15]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[16]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[17]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[18]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[19]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[20]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Aspt.g:723:8: (a8_0= parse_ASPT_TraceLink )
            	            {
            	            // Aspt.g:723:8: (a8_0= parse_ASPT_TraceLink )
            	            // Aspt.g:724:5: a8_0= parse_ASPT_TraceLink
            	            {
            	            pushFollow(FOLLOW_parse_ASPT_TraceLink_in_parse_ASPT_TraceModel292);
            	            a8_0=parse_ASPT_TraceLink();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a8_0 != null) {
            	            						if (a8_0 != null) {
            	            							Object value = a8_0;
            	            							addObjectToList(element, ASPT.ASPTPackage.TRACE_MODEL__TRACELINKS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_8_0_1_0, a8_0, true);
            	            						copyLocalizationInfos(a8_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[21]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[22]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[23]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[24]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[25]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[26]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[27]);
            	            			}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[28]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[29]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[30]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[31]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[32]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[33]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[34]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_ASPT_TraceModel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPT_TraceModel"



    // $ANTLR start "parse_ASPT_TraceNode"
    // Aspt.g:770:1: parse_ASPT_TraceNode returns [ASPT.TraceNode element = null] : (a0= 'trace_node' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ')' a10= '.' |c0= parse_ASPT_TraceNbNode );
    public final ASPT.TraceNode parse_ASPT_TraceNode() throws RecognitionException {
        ASPT.TraceNode element =  null;

        int parse_ASPT_TraceNode_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        ASPT.TraceNbNode c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Aspt.g:773:2: (a0= 'trace_node' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ')' a10= '.' |c0= parse_ASPT_TraceNbNode )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                alt3=1;
            }
            else if ( (LA3_0==16) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // Aspt.g:774:2: a0= 'trace_node' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ')' a10= '.'
                    {
                    a0=(Token)match(input,18,FOLLOW_18_in_parse_ASPT_TraceNode348); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_0, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[35]);
                    	}

                    a1=(Token)match(input,8,FOLLOW_8_in_parse_ASPT_TraceNode362); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_1, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[36]);
                    	}

                    // Aspt.g:802:2: (a2= TEXT )
                    // Aspt.g:803:3: a2= TEXT
                    {
                    a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceNode380); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    				startIncompleteElement(element);
                    			}
                    			if (a2 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__METAMODEL), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__METAMODEL), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_2, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[37]);
                    	}

                    a3=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNode401); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_3, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[38]);
                    	}

                    // Aspt.g:852:2: (a4= TEXT )
                    // Aspt.g:853:3: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceNode419); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    				startIncompleteElement(element);
                    			}
                    			if (a4 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__ID), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__ID), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_4, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[39]);
                    	}

                    a5=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNode440); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_5, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[40]);
                    	}

                    // Aspt.g:902:2: (a6= QUOTED_34_34_92 )
                    // Aspt.g:903:3: a6= QUOTED_34_34_92
                    {
                    a6=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNode458); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    				startIncompleteElement(element);
                    			}
                    			if (a6 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__IDX), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__IDX), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_6, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[41]);
                    	}

                    a7=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNode479); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_7, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[42]);
                    	}

                    // Aspt.g:952:2: (a8= TEXT )
                    // Aspt.g:953:3: a8= TEXT
                    {
                    a8=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceNode497); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    				startIncompleteElement(element);
                    			}
                    			if (a8 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__TYPE), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__TYPE), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_8, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[43]);
                    	}

                    a9=(Token)match(input,9,FOLLOW_9_in_parse_ASPT_TraceNode518); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_9, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[44]);
                    	}

                    a10=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceNode532); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_10, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[45]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[46]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[47]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[48]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[49]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[50]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[51]);
                    	}

                    }
                    break;
                case 2 :
                    // Aspt.g:1024:2: c0= parse_ASPT_TraceNbNode
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceNbNode_in_parse_ASPT_TraceNode551);
                    c0=parse_ASPT_TraceNbNode();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_ASPT_TraceNode_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPT_TraceNode"



    // $ANTLR start "parse_ASPT_TraceProp"
    // Aspt.g:1028:1: parse_ASPT_TraceProp returns [ASPT.TraceProp element = null] : (a0= 'trace_prop' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= QUOTED_34_34_92 ) a11= ',' (a12= TEXT ) a13= ',' (a14= QUOTED_34_34_92 ) a15= ')' a16= '.' |c0= parse_ASPT_TraceNbProp );
    public final ASPT.TraceProp parse_ASPT_TraceProp() throws RecognitionException {
        ASPT.TraceProp element =  null;

        int parse_ASPT_TraceProp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a16=null;
        ASPT.TraceNbProp c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Aspt.g:1031:2: (a0= 'trace_prop' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= QUOTED_34_34_92 ) a11= ',' (a12= TEXT ) a13= ',' (a14= QUOTED_34_34_92 ) a15= ')' a16= '.' |c0= parse_ASPT_TraceNbProp )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            else if ( (LA4_0==17) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // Aspt.g:1032:2: a0= 'trace_prop' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= QUOTED_34_34_92 ) a11= ',' (a12= TEXT ) a13= ',' (a14= QUOTED_34_34_92 ) a15= ')' a16= '.'
                    {
                    a0=(Token)match(input,19,FOLLOW_19_in_parse_ASPT_TraceProp576); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_0, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[52]);
                    	}

                    a1=(Token)match(input,8,FOLLOW_8_in_parse_ASPT_TraceProp590); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_1, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[53]);
                    	}

                    // Aspt.g:1060:2: (a2= TEXT )
                    // Aspt.g:1061:3: a2= TEXT
                    {
                    a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceProp608); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    				startIncompleteElement(element);
                    			}
                    			if (a2 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__METAMODEL), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__METAMODEL), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_2, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[54]);
                    	}

                    a3=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceProp629); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_3, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[55]);
                    	}

                    // Aspt.g:1110:2: (a4= TEXT )
                    // Aspt.g:1111:3: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceProp647); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    				startIncompleteElement(element);
                    			}
                    			if (a4 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__ID), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__ID), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_4, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[56]);
                    	}

                    a5=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceProp668); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_5, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[57]);
                    	}

                    // Aspt.g:1160:2: (a6= QUOTED_34_34_92 )
                    // Aspt.g:1161:3: a6= QUOTED_34_34_92
                    {
                    a6=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceProp686); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    				startIncompleteElement(element);
                    			}
                    			if (a6 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDX), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDX), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_6, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[58]);
                    	}

                    a7=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceProp707); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_7, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[59]);
                    	}

                    // Aspt.g:1210:2: (a8= TEXT )
                    // Aspt.g:1211:3: a8= TEXT
                    {
                    a8=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceProp725); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    				startIncompleteElement(element);
                    			}
                    			if (a8 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDP), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDP), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_8, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[60]);
                    	}

                    a9=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceProp746); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_9, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[61]);
                    	}

                    // Aspt.g:1260:2: (a10= QUOTED_34_34_92 )
                    // Aspt.g:1261:3: a10= QUOTED_34_34_92
                    {
                    a10=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceProp764); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    				startIncompleteElement(element);
                    			}
                    			if (a10 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDPX), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDPX), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_10, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[62]);
                    	}

                    a11=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceProp785); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_11, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[63]);
                    	}

                    // Aspt.g:1310:2: (a12= TEXT )
                    // Aspt.g:1311:3: a12= TEXT
                    {
                    a12=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceProp803); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    				startIncompleteElement(element);
                    			}
                    			if (a12 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__TYPE), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__TYPE), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_12, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[64]);
                    	}

                    a13=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceProp824); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_13, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[65]);
                    	}

                    // Aspt.g:1360:2: (a14= QUOTED_34_34_92 )
                    // Aspt.g:1361:3: a14= QUOTED_34_34_92
                    {
                    a14=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceProp842); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    				startIncompleteElement(element);
                    			}
                    			if (a14 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__VALUE), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a14).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__VALUE), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_14, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[66]);
                    	}

                    a15=(Token)match(input,9,FOLLOW_9_in_parse_ASPT_TraceProp863); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_15, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[67]);
                    	}

                    a16=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceProp877); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_16, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[68]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[69]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[70]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[71]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[72]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[73]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[74]);
                    	}

                    }
                    break;
                case 2 :
                    // Aspt.g:1432:2: c0= parse_ASPT_TraceNbProp
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceNbProp_in_parse_ASPT_TraceProp896);
                    c0=parse_ASPT_TraceNbProp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_ASPT_TraceProp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPT_TraceProp"



    // $ANTLR start "parse_ASPT_TraceEdge"
    // Aspt.g:1436:1: parse_ASPT_TraceEdge returns [ASPT.TraceEdge element = null] : (a0= 'trace_edge' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= TEXT ) a11= ',' (a12= QUOTED_34_34_92 ) a13= ',' (a14= TEXT ) a15= ',' (a16= QUOTED_34_34_92 ) a17= ')' a18= '.' |c0= parse_ASPT_TraceNbEdge );
    public final ASPT.TraceEdge parse_ASPT_TraceEdge() throws RecognitionException {
        ASPT.TraceEdge element =  null;

        int parse_ASPT_TraceEdge_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a16=null;
        Token a17=null;
        Token a18=null;
        ASPT.TraceNbEdge c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Aspt.g:1439:2: (a0= 'trace_edge' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= TEXT ) a11= ',' (a12= QUOTED_34_34_92 ) a13= ',' (a14= TEXT ) a15= ',' (a16= QUOTED_34_34_92 ) a17= ')' a18= '.' |c0= parse_ASPT_TraceNbEdge )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            else if ( (LA5_0==15) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // Aspt.g:1440:2: a0= 'trace_edge' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= TEXT ) a11= ',' (a12= QUOTED_34_34_92 ) a13= ',' (a14= TEXT ) a15= ',' (a16= QUOTED_34_34_92 ) a17= ')' a18= '.'
                    {
                    a0=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceEdge921); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_0, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[75]);
                    	}

                    a1=(Token)match(input,8,FOLLOW_8_in_parse_ASPT_TraceEdge935); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_1, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[76]);
                    	}

                    // Aspt.g:1468:2: (a2= TEXT )
                    // Aspt.g:1469:3: a2= TEXT
                    {
                    a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceEdge953); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a2 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__METAMODEL), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__METAMODEL), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_2, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[77]);
                    	}

                    a3=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceEdge974); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_3, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[78]);
                    	}

                    // Aspt.g:1518:2: (a4= TEXT )
                    // Aspt.g:1519:3: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceEdge992); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a4 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__ID), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__ID), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_4, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[79]);
                    	}

                    a5=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceEdge1013); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_5, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[80]);
                    	}

                    // Aspt.g:1568:2: (a6= QUOTED_34_34_92 )
                    // Aspt.g:1569:3: a6= QUOTED_34_34_92
                    {
                    a6=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceEdge1031); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a6 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDX), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDX), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_6, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[81]);
                    	}

                    a7=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceEdge1052); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_7, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[82]);
                    	}

                    // Aspt.g:1618:2: (a8= TEXT )
                    // Aspt.g:1619:3: a8= TEXT
                    {
                    a8=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceEdge1070); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a8 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__TYPE), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__TYPE), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_8, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[83]);
                    	}

                    a9=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceEdge1091); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_9, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[84]);
                    	}

                    // Aspt.g:1668:2: (a10= TEXT )
                    // Aspt.g:1669:3: a10= TEXT
                    {
                    a10=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceEdge1109); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a10 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDS), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDS), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_10, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[85]);
                    	}

                    a11=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceEdge1130); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_11, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[86]);
                    	}

                    // Aspt.g:1718:2: (a12= QUOTED_34_34_92 )
                    // Aspt.g:1719:3: a12= QUOTED_34_34_92
                    {
                    a12=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceEdge1148); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a12 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDSX), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDSX), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_12, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[87]);
                    	}

                    a13=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceEdge1169); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_13, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[88]);
                    	}

                    // Aspt.g:1768:2: (a14= TEXT )
                    // Aspt.g:1769:3: a14= TEXT
                    {
                    a14=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceEdge1187); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a14 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDT), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a14).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDT), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_14, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[89]);
                    	}

                    a15=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceEdge1208); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_15, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[90]);
                    	}

                    // Aspt.g:1818:2: (a16= QUOTED_34_34_92 )
                    // Aspt.g:1819:3: a16= QUOTED_34_34_92
                    {
                    a16=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceEdge1226); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a16 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a16.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDTX), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a16).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDTX), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_16, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a16, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[91]);
                    	}

                    a17=(Token)match(input,9,FOLLOW_9_in_parse_ASPT_TraceEdge1247); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_17, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[92]);
                    	}

                    a18=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceEdge1261); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_18, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[93]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[94]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[95]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[96]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[97]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[98]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[99]);
                    	}

                    }
                    break;
                case 2 :
                    // Aspt.g:1890:2: c0= parse_ASPT_TraceNbEdge
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceNbEdge_in_parse_ASPT_TraceEdge1280);
                    c0=parse_ASPT_TraceNbEdge();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_ASPT_TraceEdge_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPT_TraceEdge"



    // $ANTLR start "parse_ASPT_TraceNbEdge"
    // Aspt.g:1894:1: parse_ASPT_TraceNbEdge returns [ASPT.TraceNbEdge element = null] : a0= 'trace_nb_edge' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= TEXT ) a11= ',' (a12= QUOTED_34_34_92 ) a13= ',' (a14= TEXT ) a15= ',' (a16= QUOTED_34_34_92 ) a17= ')' a18= '.' ;
    public final ASPT.TraceNbEdge parse_ASPT_TraceNbEdge() throws RecognitionException {
        ASPT.TraceNbEdge element =  null;

        int parse_ASPT_TraceNbEdge_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a16=null;
        Token a17=null;
        Token a18=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Aspt.g:1897:2: (a0= 'trace_nb_edge' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= TEXT ) a11= ',' (a12= QUOTED_34_34_92 ) a13= ',' (a14= TEXT ) a15= ',' (a16= QUOTED_34_34_92 ) a17= ')' a18= '.' )
            // Aspt.g:1898:2: a0= 'trace_nb_edge' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= TEXT ) a11= ',' (a12= QUOTED_34_34_92 ) a13= ',' (a14= TEXT ) a15= ',' (a16= QUOTED_34_34_92 ) a17= ')' a18= '.'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_ASPT_TraceNbEdge1305); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[100]);
            	}

            a1=(Token)match(input,8,FOLLOW_8_in_parse_ASPT_TraceNbEdge1319); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[101]);
            	}

            // Aspt.g:1926:2: (a2= TEXT )
            // Aspt.g:1927:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceNbEdge1337); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__METAMODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__METAMODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_2, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[102]);
            	}

            a3=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbEdge1358); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[103]);
            	}

            // Aspt.g:1976:2: (a4= TEXT )
            // Aspt.g:1977:3: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceNbEdge1376); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a4 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__ID), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__ID), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_4, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[104]);
            	}

            a5=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbEdge1397); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[105]);
            	}

            // Aspt.g:2026:2: (a6= QUOTED_34_34_92 )
            // Aspt.g:2027:3: a6= QUOTED_34_34_92
            {
            a6=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNbEdge1415); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a6 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_6, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[106]);
            	}

            a7=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbEdge1436); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[107]);
            	}

            // Aspt.g:2076:2: (a8= TEXT )
            // Aspt.g:2077:3: a8= TEXT
            {
            a8=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceNbEdge1454); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a8 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__TYPE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__TYPE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_8, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[108]);
            	}

            a9=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbEdge1475); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_9, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[109]);
            	}

            // Aspt.g:2126:2: (a10= TEXT )
            // Aspt.g:2127:3: a10= TEXT
            {
            a10=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceNbEdge1493); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a10 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDS), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_10, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[110]);
            	}

            a11=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbEdge1514); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_11, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[111]);
            	}

            // Aspt.g:2176:2: (a12= QUOTED_34_34_92 )
            // Aspt.g:2177:3: a12= QUOTED_34_34_92
            {
            a12=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNbEdge1532); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a12 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDSX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDSX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_12, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[112]);
            	}

            a13=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbEdge1553); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_13, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[113]);
            	}

            // Aspt.g:2226:2: (a14= TEXT )
            // Aspt.g:2227:3: a14= TEXT
            {
            a14=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceNbEdge1571); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a14 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a14).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_14, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[114]);
            	}

            a15=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbEdge1592); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_15, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[115]);
            	}

            // Aspt.g:2276:2: (a16= QUOTED_34_34_92 )
            // Aspt.g:2277:3: a16= QUOTED_34_34_92
            {
            a16=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNbEdge1610); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a16 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a16.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDTX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a16).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDTX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_16, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a16, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[116]);
            	}

            a17=(Token)match(input,9,FOLLOW_9_in_parse_ASPT_TraceNbEdge1631); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_17, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[117]);
            	}

            a18=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceNbEdge1645); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_18, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[118]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[119]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[120]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[121]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[122]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[123]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[124]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_ASPT_TraceNbEdge_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPT_TraceNbEdge"



    // $ANTLR start "parse_ASPT_TraceNbProp"
    // Aspt.g:2348:1: parse_ASPT_TraceNbProp returns [ASPT.TraceNbProp element = null] : a0= 'trace_nb_prop' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= QUOTED_34_34_92 ) a11= ',' (a12= TEXT ) a13= ',' (a14= QUOTED_34_34_92 ) a15= ')' a16= '.' ;
    public final ASPT.TraceNbProp parse_ASPT_TraceNbProp() throws RecognitionException {
        ASPT.TraceNbProp element =  null;

        int parse_ASPT_TraceNbProp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a16=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Aspt.g:2351:2: (a0= 'trace_nb_prop' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= QUOTED_34_34_92 ) a11= ',' (a12= TEXT ) a13= ',' (a14= QUOTED_34_34_92 ) a15= ')' a16= '.' )
            // Aspt.g:2352:2: a0= 'trace_nb_prop' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= QUOTED_34_34_92 ) a11= ',' (a12= TEXT ) a13= ',' (a14= QUOTED_34_34_92 ) a15= ')' a16= '.'
            {
            a0=(Token)match(input,17,FOLLOW_17_in_parse_ASPT_TraceNbProp1674); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[125]);
            	}

            a1=(Token)match(input,8,FOLLOW_8_in_parse_ASPT_TraceNbProp1688); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[126]);
            	}

            // Aspt.g:2380:2: (a2= TEXT )
            // Aspt.g:2381:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceNbProp1706); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__METAMODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__METAMODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_2, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[127]);
            	}

            a3=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbProp1727); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[128]);
            	}

            // Aspt.g:2430:2: (a4= TEXT )
            // Aspt.g:2431:3: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceNbProp1745); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            				startIncompleteElement(element);
            			}
            			if (a4 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__ID), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__ID), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_4, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[129]);
            	}

            a5=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbProp1766); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[130]);
            	}

            // Aspt.g:2480:2: (a6= QUOTED_34_34_92 )
            // Aspt.g:2481:3: a6= QUOTED_34_34_92
            {
            a6=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNbProp1784); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            				startIncompleteElement(element);
            			}
            			if (a6 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_6, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[131]);
            	}

            a7=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbProp1805); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[132]);
            	}

            // Aspt.g:2530:2: (a8= TEXT )
            // Aspt.g:2531:3: a8= TEXT
            {
            a8=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceNbProp1823); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            				startIncompleteElement(element);
            			}
            			if (a8 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDP), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDP), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_8, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[133]);
            	}

            a9=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbProp1844); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_9, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[134]);
            	}

            // Aspt.g:2580:2: (a10= QUOTED_34_34_92 )
            // Aspt.g:2581:3: a10= QUOTED_34_34_92
            {
            a10=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNbProp1862); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            				startIncompleteElement(element);
            			}
            			if (a10 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDPX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDPX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_10, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[135]);
            	}

            a11=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbProp1883); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_11, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[136]);
            	}

            // Aspt.g:2630:2: (a12= TEXT )
            // Aspt.g:2631:3: a12= TEXT
            {
            a12=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceNbProp1901); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            				startIncompleteElement(element);
            			}
            			if (a12 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__TYPE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__TYPE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_12, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[137]);
            	}

            a13=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbProp1922); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_13, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[138]);
            	}

            // Aspt.g:2680:2: (a14= QUOTED_34_34_92 )
            // Aspt.g:2681:3: a14= QUOTED_34_34_92
            {
            a14=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNbProp1940); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            				startIncompleteElement(element);
            			}
            			if (a14 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__VALUE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a14).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__VALUE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_14, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[139]);
            	}

            a15=(Token)match(input,9,FOLLOW_9_in_parse_ASPT_TraceNbProp1961); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_15, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[140]);
            	}

            a16=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceNbProp1975); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_16, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[141]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[142]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[143]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[144]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[145]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[146]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[147]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_ASPT_TraceNbProp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPT_TraceNbProp"



    // $ANTLR start "parse_ASPT_TraceNbNode"
    // Aspt.g:2752:1: parse_ASPT_TraceNbNode returns [ASPT.TraceNbNode element = null] : a0= 'trace_nb_node' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ')' a10= '.' ;
    public final ASPT.TraceNbNode parse_ASPT_TraceNbNode() throws RecognitionException {
        ASPT.TraceNbNode element =  null;

        int parse_ASPT_TraceNbNode_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Aspt.g:2755:2: (a0= 'trace_nb_node' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ')' a10= '.' )
            // Aspt.g:2756:2: a0= 'trace_nb_node' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ')' a10= '.'
            {
            a0=(Token)match(input,16,FOLLOW_16_in_parse_ASPT_TraceNbNode2004); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[148]);
            	}

            a1=(Token)match(input,8,FOLLOW_8_in_parse_ASPT_TraceNbNode2018); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[149]);
            	}

            // Aspt.g:2784:2: (a2= TEXT )
            // Aspt.g:2785:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceNbNode2036); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__METAMODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__METAMODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_2, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[150]);
            	}

            a3=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbNode2057); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[151]);
            	}

            // Aspt.g:2834:2: (a4= TEXT )
            // Aspt.g:2835:3: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceNbNode2075); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            				startIncompleteElement(element);
            			}
            			if (a4 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__ID), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__ID), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_4, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[152]);
            	}

            a5=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbNode2096); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[153]);
            	}

            // Aspt.g:2884:2: (a6= QUOTED_34_34_92 )
            // Aspt.g:2885:3: a6= QUOTED_34_34_92
            {
            a6=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNbNode2114); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            				startIncompleteElement(element);
            			}
            			if (a6 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__IDX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__IDX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_6, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[154]);
            	}

            a7=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceNbNode2135); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[155]);
            	}

            // Aspt.g:2934:2: (a8= TEXT )
            // Aspt.g:2935:3: a8= TEXT
            {
            a8=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceNbNode2153); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            				startIncompleteElement(element);
            			}
            			if (a8 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__TYPE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__TYPE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_8, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[156]);
            	}

            a9=(Token)match(input,9,FOLLOW_9_in_parse_ASPT_TraceNbNode2174); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_9, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[157]);
            	}

            a10=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceNbNode2188); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_10, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[158]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[159]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[160]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[161]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[162]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[163]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[164]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_ASPT_TraceNbNode_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPT_TraceNbNode"



    // $ANTLR start "parse_ASPT_TraceLink"
    // Aspt.g:3006:1: parse_ASPT_TraceLink returns [ASPT.TraceLink element = null] : a0= 'trace_link' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= QUOTED_34_34_92 ) a11= ',' (a12= TEXT ) a13= ',' (a14= QUOTED_34_34_92 ) a15= ')' a16= '.' ;
    public final ASPT.TraceLink parse_ASPT_TraceLink() throws RecognitionException {
        ASPT.TraceLink element =  null;

        int parse_ASPT_TraceLink_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a16=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Aspt.g:3009:2: (a0= 'trace_link' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= QUOTED_34_34_92 ) a11= ',' (a12= TEXT ) a13= ',' (a14= QUOTED_34_34_92 ) a15= ')' a16= '.' )
            // Aspt.g:3010:2: a0= 'trace_link' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= QUOTED_34_34_92 ) a11= ',' (a12= TEXT ) a13= ',' (a14= QUOTED_34_34_92 ) a15= ')' a16= '.'
            {
            a0=(Token)match(input,13,FOLLOW_13_in_parse_ASPT_TraceLink2217); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[165]);
            	}

            a1=(Token)match(input,8,FOLLOW_8_in_parse_ASPT_TraceLink2231); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[166]);
            	}

            // Aspt.g:3038:2: (a2= TEXT )
            // Aspt.g:3039:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceLink2249); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__METAMODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__METAMODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_2, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[167]);
            	}

            a3=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceLink2270); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[168]);
            	}

            // Aspt.g:3088:2: (a4= TEXT )
            // Aspt.g:3089:3: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceLink2288); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            				startIncompleteElement(element);
            			}
            			if (a4 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__ID), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__ID), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_4, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[169]);
            	}

            a5=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceLink2309); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[170]);
            	}

            // Aspt.g:3138:2: (a6= QUOTED_34_34_92 )
            // Aspt.g:3139:3: a6= QUOTED_34_34_92
            {
            a6=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceLink2327); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            				startIncompleteElement(element);
            			}
            			if (a6 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_6, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[171]);
            	}

            a7=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceLink2348); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[172]);
            	}

            // Aspt.g:3188:2: (a8= TEXT )
            // Aspt.g:3189:3: a8= TEXT
            {
            a8=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceLink2366); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            				startIncompleteElement(element);
            			}
            			if (a8 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDREF), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDREF), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_8, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[173]);
            	}

            a9=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceLink2387); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_9, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[174]);
            	}

            // Aspt.g:3238:2: (a10= QUOTED_34_34_92 )
            // Aspt.g:3239:3: a10= QUOTED_34_34_92
            {
            a10=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceLink2405); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            				startIncompleteElement(element);
            			}
            			if (a10 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDREFX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDREFX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_10, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[175]);
            	}

            a11=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceLink2426); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_11, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[176]);
            	}

            // Aspt.g:3288:2: (a12= TEXT )
            // Aspt.g:3289:3: a12= TEXT
            {
            a12=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPT_TraceLink2444); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            				startIncompleteElement(element);
            			}
            			if (a12 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__TYPE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__TYPE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_12, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[177]);
            	}

            a13=(Token)match(input,10,FOLLOW_10_in_parse_ASPT_TraceLink2465); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_13, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[178]);
            	}

            // Aspt.g:3338:2: (a14= QUOTED_34_34_92 )
            // Aspt.g:3339:3: a14= QUOTED_34_34_92
            {
            a14=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceLink2483); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            				startIncompleteElement(element);
            			}
            			if (a14 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__RELATION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a14).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__RELATION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_14, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[179]);
            	}

            a15=(Token)match(input,9,FOLLOW_9_in_parse_ASPT_TraceLink2504); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_15, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[180]);
            	}

            a16=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceLink2518); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_16, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[181]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[182]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[183]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[184]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[185]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[186]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[187]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_ASPT_TraceLink_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPT_TraceLink"



    // $ANTLR start "parse_ASPT_TraceElement"
    // Aspt.g:3410:1: parse_ASPT_TraceElement returns [ASPT.TraceElement element = null] : (c0= parse_ASPT_TraceNode |c1= parse_ASPT_TraceProp |c2= parse_ASPT_TraceEdge |c3= parse_ASPT_TraceNbEdge |c4= parse_ASPT_TraceNbProp |c5= parse_ASPT_TraceNbNode |c6= parse_ASPT_TraceLink );
    public final ASPT.TraceElement parse_ASPT_TraceElement() throws RecognitionException {
        ASPT.TraceElement element =  null;

        int parse_ASPT_TraceElement_StartIndex = input.index();

        ASPT.TraceNode c0 =null;

        ASPT.TraceProp c1 =null;

        ASPT.TraceEdge c2 =null;

        ASPT.TraceNbEdge c3 =null;

        ASPT.TraceNbProp c4 =null;

        ASPT.TraceNbNode c5 =null;

        ASPT.TraceLink c6 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Aspt.g:3411:2: (c0= parse_ASPT_TraceNode |c1= parse_ASPT_TraceProp |c2= parse_ASPT_TraceEdge |c3= parse_ASPT_TraceNbEdge |c4= parse_ASPT_TraceNbProp |c5= parse_ASPT_TraceNbNode |c6= parse_ASPT_TraceLink )
            int alt6=7;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt6=1;
                }
                break;
            case 16:
                {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==8) ) {
                    int LA6_8 = input.LA(3);

                    if ( (LA6_8==TEXT) ) {
                        int LA6_11 = input.LA(4);

                        if ( (LA6_11==10) ) {
                            int LA6_14 = input.LA(5);

                            if ( (LA6_14==TEXT) ) {
                                int LA6_17 = input.LA(6);

                                if ( (LA6_17==10) ) {
                                    int LA6_20 = input.LA(7);

                                    if ( (LA6_20==QUOTED_34_34_92) ) {
                                        int LA6_23 = input.LA(8);

                                        if ( (LA6_23==10) ) {
                                            int LA6_26 = input.LA(9);

                                            if ( (LA6_26==TEXT) ) {
                                                int LA6_29 = input.LA(10);

                                                if ( (LA6_29==9) ) {
                                                    int LA6_32 = input.LA(11);

                                                    if ( (LA6_32==11) ) {
                                                        int LA6_35 = input.LA(12);

                                                        if ( (synpred6_Aspt()) ) {
                                                            alt6=1;
                                                        }
                                                        else if ( (synpred11_Aspt()) ) {
                                                            alt6=6;
                                                        }
                                                        else {
                                                            if (state.backtracking>0) {state.failed=true; return element;}
                                                            NoViableAltException nvae =
                                                                new NoViableAltException("", 6, 35, input);

                                                            throw nvae;

                                                        }
                                                    }
                                                    else {
                                                        if (state.backtracking>0) {state.failed=true; return element;}
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("", 6, 32, input);

                                                        throw nvae;

                                                    }
                                                }
                                                else {
                                                    if (state.backtracking>0) {state.failed=true; return element;}
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("", 6, 29, input);

                                                    throw nvae;

                                                }
                                            }
                                            else {
                                                if (state.backtracking>0) {state.failed=true; return element;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 6, 26, input);

                                                throw nvae;

                                            }
                                        }
                                        else {
                                            if (state.backtracking>0) {state.failed=true; return element;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 6, 23, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        if (state.backtracking>0) {state.failed=true; return element;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 6, 20, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 6, 17, input);

                                    throw nvae;

                                }
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 14, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 11, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 8, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;

                }
                }
                break;
            case 19:
                {
                alt6=2;
                }
                break;
            case 17:
                {
                int LA6_4 = input.LA(2);

                if ( (LA6_4==8) ) {
                    int LA6_9 = input.LA(3);

                    if ( (LA6_9==TEXT) ) {
                        int LA6_12 = input.LA(4);

                        if ( (LA6_12==10) ) {
                            int LA6_15 = input.LA(5);

                            if ( (LA6_15==TEXT) ) {
                                int LA6_18 = input.LA(6);

                                if ( (LA6_18==10) ) {
                                    int LA6_21 = input.LA(7);

                                    if ( (LA6_21==QUOTED_34_34_92) ) {
                                        int LA6_24 = input.LA(8);

                                        if ( (LA6_24==10) ) {
                                            int LA6_27 = input.LA(9);

                                            if ( (LA6_27==TEXT) ) {
                                                int LA6_30 = input.LA(10);

                                                if ( (LA6_30==10) ) {
                                                    int LA6_33 = input.LA(11);

                                                    if ( (LA6_33==QUOTED_34_34_92) ) {
                                                        int LA6_36 = input.LA(12);

                                                        if ( (LA6_36==10) ) {
                                                            int LA6_39 = input.LA(13);

                                                            if ( (LA6_39==TEXT) ) {
                                                                int LA6_41 = input.LA(14);

                                                                if ( (LA6_41==10) ) {
                                                                    int LA6_43 = input.LA(15);

                                                                    if ( (LA6_43==QUOTED_34_34_92) ) {
                                                                        int LA6_45 = input.LA(16);

                                                                        if ( (LA6_45==9) ) {
                                                                            int LA6_47 = input.LA(17);

                                                                            if ( (LA6_47==11) ) {
                                                                                int LA6_49 = input.LA(18);

                                                                                if ( (synpred7_Aspt()) ) {
                                                                                    alt6=2;
                                                                                }
                                                                                else if ( (synpred10_Aspt()) ) {
                                                                                    alt6=5;
                                                                                }
                                                                                else {
                                                                                    if (state.backtracking>0) {state.failed=true; return element;}
                                                                                    NoViableAltException nvae =
                                                                                        new NoViableAltException("", 6, 49, input);

                                                                                    throw nvae;

                                                                                }
                                                                            }
                                                                            else {
                                                                                if (state.backtracking>0) {state.failed=true; return element;}
                                                                                NoViableAltException nvae =
                                                                                    new NoViableAltException("", 6, 47, input);

                                                                                throw nvae;

                                                                            }
                                                                        }
                                                                        else {
                                                                            if (state.backtracking>0) {state.failed=true; return element;}
                                                                            NoViableAltException nvae =
                                                                                new NoViableAltException("", 6, 45, input);

                                                                            throw nvae;

                                                                        }
                                                                    }
                                                                    else {
                                                                        if (state.backtracking>0) {state.failed=true; return element;}
                                                                        NoViableAltException nvae =
                                                                            new NoViableAltException("", 6, 43, input);

                                                                        throw nvae;

                                                                    }
                                                                }
                                                                else {
                                                                    if (state.backtracking>0) {state.failed=true; return element;}
                                                                    NoViableAltException nvae =
                                                                        new NoViableAltException("", 6, 41, input);

                                                                    throw nvae;

                                                                }
                                                            }
                                                            else {
                                                                if (state.backtracking>0) {state.failed=true; return element;}
                                                                NoViableAltException nvae =
                                                                    new NoViableAltException("", 6, 39, input);

                                                                throw nvae;

                                                            }
                                                        }
                                                        else {
                                                            if (state.backtracking>0) {state.failed=true; return element;}
                                                            NoViableAltException nvae =
                                                                new NoViableAltException("", 6, 36, input);

                                                            throw nvae;

                                                        }
                                                    }
                                                    else {
                                                        if (state.backtracking>0) {state.failed=true; return element;}
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("", 6, 33, input);

                                                        throw nvae;

                                                    }
                                                }
                                                else {
                                                    if (state.backtracking>0) {state.failed=true; return element;}
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("", 6, 30, input);

                                                    throw nvae;

                                                }
                                            }
                                            else {
                                                if (state.backtracking>0) {state.failed=true; return element;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 6, 27, input);

                                                throw nvae;

                                            }
                                        }
                                        else {
                                            if (state.backtracking>0) {state.failed=true; return element;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 6, 24, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        if (state.backtracking>0) {state.failed=true; return element;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 6, 21, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 6, 18, input);

                                    throw nvae;

                                }
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 15, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 12, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 9, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 4, input);

                    throw nvae;

                }
                }
                break;
            case 12:
                {
                alt6=3;
                }
                break;
            case 15:
                {
                int LA6_6 = input.LA(2);

                if ( (LA6_6==8) ) {
                    int LA6_10 = input.LA(3);

                    if ( (LA6_10==TEXT) ) {
                        int LA6_13 = input.LA(4);

                        if ( (LA6_13==10) ) {
                            int LA6_16 = input.LA(5);

                            if ( (LA6_16==TEXT) ) {
                                int LA6_19 = input.LA(6);

                                if ( (LA6_19==10) ) {
                                    int LA6_22 = input.LA(7);

                                    if ( (LA6_22==QUOTED_34_34_92) ) {
                                        int LA6_25 = input.LA(8);

                                        if ( (LA6_25==10) ) {
                                            int LA6_28 = input.LA(9);

                                            if ( (LA6_28==TEXT) ) {
                                                int LA6_31 = input.LA(10);

                                                if ( (LA6_31==10) ) {
                                                    int LA6_34 = input.LA(11);

                                                    if ( (LA6_34==TEXT) ) {
                                                        int LA6_37 = input.LA(12);

                                                        if ( (LA6_37==10) ) {
                                                            int LA6_40 = input.LA(13);

                                                            if ( (LA6_40==QUOTED_34_34_92) ) {
                                                                int LA6_42 = input.LA(14);

                                                                if ( (LA6_42==10) ) {
                                                                    int LA6_44 = input.LA(15);

                                                                    if ( (LA6_44==TEXT) ) {
                                                                        int LA6_46 = input.LA(16);

                                                                        if ( (LA6_46==10) ) {
                                                                            int LA6_48 = input.LA(17);

                                                                            if ( (LA6_48==QUOTED_34_34_92) ) {
                                                                                int LA6_50 = input.LA(18);

                                                                                if ( (LA6_50==9) ) {
                                                                                    int LA6_52 = input.LA(19);

                                                                                    if ( (LA6_52==11) ) {
                                                                                        int LA6_53 = input.LA(20);

                                                                                        if ( (synpred8_Aspt()) ) {
                                                                                            alt6=3;
                                                                                        }
                                                                                        else if ( (synpred9_Aspt()) ) {
                                                                                            alt6=4;
                                                                                        }
                                                                                        else {
                                                                                            if (state.backtracking>0) {state.failed=true; return element;}
                                                                                            NoViableAltException nvae =
                                                                                                new NoViableAltException("", 6, 53, input);

                                                                                            throw nvae;

                                                                                        }
                                                                                    }
                                                                                    else {
                                                                                        if (state.backtracking>0) {state.failed=true; return element;}
                                                                                        NoViableAltException nvae =
                                                                                            new NoViableAltException("", 6, 52, input);

                                                                                        throw nvae;

                                                                                    }
                                                                                }
                                                                                else {
                                                                                    if (state.backtracking>0) {state.failed=true; return element;}
                                                                                    NoViableAltException nvae =
                                                                                        new NoViableAltException("", 6, 50, input);

                                                                                    throw nvae;

                                                                                }
                                                                            }
                                                                            else {
                                                                                if (state.backtracking>0) {state.failed=true; return element;}
                                                                                NoViableAltException nvae =
                                                                                    new NoViableAltException("", 6, 48, input);

                                                                                throw nvae;

                                                                            }
                                                                        }
                                                                        else {
                                                                            if (state.backtracking>0) {state.failed=true; return element;}
                                                                            NoViableAltException nvae =
                                                                                new NoViableAltException("", 6, 46, input);

                                                                            throw nvae;

                                                                        }
                                                                    }
                                                                    else {
                                                                        if (state.backtracking>0) {state.failed=true; return element;}
                                                                        NoViableAltException nvae =
                                                                            new NoViableAltException("", 6, 44, input);

                                                                        throw nvae;

                                                                    }
                                                                }
                                                                else {
                                                                    if (state.backtracking>0) {state.failed=true; return element;}
                                                                    NoViableAltException nvae =
                                                                        new NoViableAltException("", 6, 42, input);

                                                                    throw nvae;

                                                                }
                                                            }
                                                            else {
                                                                if (state.backtracking>0) {state.failed=true; return element;}
                                                                NoViableAltException nvae =
                                                                    new NoViableAltException("", 6, 40, input);

                                                                throw nvae;

                                                            }
                                                        }
                                                        else {
                                                            if (state.backtracking>0) {state.failed=true; return element;}
                                                            NoViableAltException nvae =
                                                                new NoViableAltException("", 6, 37, input);

                                                            throw nvae;

                                                        }
                                                    }
                                                    else {
                                                        if (state.backtracking>0) {state.failed=true; return element;}
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("", 6, 34, input);

                                                        throw nvae;

                                                    }
                                                }
                                                else {
                                                    if (state.backtracking>0) {state.failed=true; return element;}
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("", 6, 31, input);

                                                    throw nvae;

                                                }
                                            }
                                            else {
                                                if (state.backtracking>0) {state.failed=true; return element;}
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 6, 28, input);

                                                throw nvae;

                                            }
                                        }
                                        else {
                                            if (state.backtracking>0) {state.failed=true; return element;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 6, 25, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        if (state.backtracking>0) {state.failed=true; return element;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 6, 22, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return element;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 6, 19, input);

                                    throw nvae;

                                }
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 16, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 13, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 10, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 6, input);

                    throw nvae;

                }
                }
                break;
            case 13:
                {
                alt6=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // Aspt.g:3412:2: c0= parse_ASPT_TraceNode
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceNode_in_parse_ASPT_TraceElement2543);
                    c0=parse_ASPT_TraceNode();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Aspt.g:3413:4: c1= parse_ASPT_TraceProp
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceProp_in_parse_ASPT_TraceElement2553);
                    c1=parse_ASPT_TraceProp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Aspt.g:3414:4: c2= parse_ASPT_TraceEdge
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceEdge_in_parse_ASPT_TraceElement2563);
                    c2=parse_ASPT_TraceEdge();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Aspt.g:3415:4: c3= parse_ASPT_TraceNbEdge
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceNbEdge_in_parse_ASPT_TraceElement2573);
                    c3=parse_ASPT_TraceNbEdge();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Aspt.g:3416:4: c4= parse_ASPT_TraceNbProp
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceNbProp_in_parse_ASPT_TraceElement2583);
                    c4=parse_ASPT_TraceNbProp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Aspt.g:3417:4: c5= parse_ASPT_TraceNbNode
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceNbNode_in_parse_ASPT_TraceElement2593);
                    c5=parse_ASPT_TraceNbNode();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Aspt.g:3418:4: c6= parse_ASPT_TraceLink
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceLink_in_parse_ASPT_TraceElement2603);
                    c6=parse_ASPT_TraceLink();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parse_ASPT_TraceElement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPT_TraceElement"

    // $ANTLR start synpred1_Aspt
    public final void synpred1_Aspt_fragment() throws RecognitionException {
        ASPT.TraceElement a7_0 =null;


        // Aspt.g:690:4: ( (a7_0= parse_ASPT_TraceElement ) )
        // Aspt.g:690:4: (a7_0= parse_ASPT_TraceElement )
        {
        // Aspt.g:690:4: (a7_0= parse_ASPT_TraceElement )
        // Aspt.g:691:5: a7_0= parse_ASPT_TraceElement
        {
        pushFollow(FOLLOW_parse_ASPT_TraceElement_in_synpred1_Aspt250);
        a7_0=parse_ASPT_TraceElement();

        state._fsp--;
        if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred1_Aspt

    // $ANTLR start synpred6_Aspt
    public final void synpred6_Aspt_fragment() throws RecognitionException {
        ASPT.TraceNode c0 =null;


        // Aspt.g:3412:2: (c0= parse_ASPT_TraceNode )
        // Aspt.g:3412:2: c0= parse_ASPT_TraceNode
        {
        pushFollow(FOLLOW_parse_ASPT_TraceNode_in_synpred6_Aspt2543);
        c0=parse_ASPT_TraceNode();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_Aspt

    // $ANTLR start synpred7_Aspt
    public final void synpred7_Aspt_fragment() throws RecognitionException {
        ASPT.TraceProp c1 =null;


        // Aspt.g:3413:4: (c1= parse_ASPT_TraceProp )
        // Aspt.g:3413:4: c1= parse_ASPT_TraceProp
        {
        pushFollow(FOLLOW_parse_ASPT_TraceProp_in_synpred7_Aspt2553);
        c1=parse_ASPT_TraceProp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred7_Aspt

    // $ANTLR start synpred8_Aspt
    public final void synpred8_Aspt_fragment() throws RecognitionException {
        ASPT.TraceEdge c2 =null;


        // Aspt.g:3414:4: (c2= parse_ASPT_TraceEdge )
        // Aspt.g:3414:4: c2= parse_ASPT_TraceEdge
        {
        pushFollow(FOLLOW_parse_ASPT_TraceEdge_in_synpred8_Aspt2563);
        c2=parse_ASPT_TraceEdge();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred8_Aspt

    // $ANTLR start synpred9_Aspt
    public final void synpred9_Aspt_fragment() throws RecognitionException {
        ASPT.TraceNbEdge c3 =null;


        // Aspt.g:3415:4: (c3= parse_ASPT_TraceNbEdge )
        // Aspt.g:3415:4: c3= parse_ASPT_TraceNbEdge
        {
        pushFollow(FOLLOW_parse_ASPT_TraceNbEdge_in_synpred9_Aspt2573);
        c3=parse_ASPT_TraceNbEdge();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred9_Aspt

    // $ANTLR start synpred10_Aspt
    public final void synpred10_Aspt_fragment() throws RecognitionException {
        ASPT.TraceNbProp c4 =null;


        // Aspt.g:3416:4: (c4= parse_ASPT_TraceNbProp )
        // Aspt.g:3416:4: c4= parse_ASPT_TraceNbProp
        {
        pushFollow(FOLLOW_parse_ASPT_TraceNbProp_in_synpred10_Aspt2583);
        c4=parse_ASPT_TraceNbProp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred10_Aspt

    // $ANTLR start synpred11_Aspt
    public final void synpred11_Aspt_fragment() throws RecognitionException {
        ASPT.TraceNbNode c5 =null;


        // Aspt.g:3417:4: (c5= parse_ASPT_TraceNbNode )
        // Aspt.g:3417:4: c5= parse_ASPT_TraceNbNode
        {
        pushFollow(FOLLOW_parse_ASPT_TraceNbNode_in_synpred11_Aspt2593);
        c5=parse_ASPT_TraceNbNode();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred11_Aspt

    // Delegated rules

    public final boolean synpred6_Aspt() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_Aspt_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_Aspt() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_Aspt_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_Aspt() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_Aspt_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_Aspt() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_Aspt_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_Aspt() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_Aspt_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Aspt() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Aspt_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_Aspt() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_Aspt_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_parse_ASPT_TraceModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_ASPT_TraceModel115 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPT_TraceModel129 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceModel147 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceModel168 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceModel186 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPT_TraceModel207 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceModel221 = new BitSet(new long[]{0x00000000000FB002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceElement_in_parse_ASPT_TraceModel250 = new BitSet(new long[]{0x00000000000FB002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceLink_in_parse_ASPT_TraceModel292 = new BitSet(new long[]{0x00000000000FB002L});
    public static final BitSet FOLLOW_18_in_parse_ASPT_TraceNode348 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPT_TraceNode362 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceNode380 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNode401 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceNode419 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNode440 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNode458 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNode479 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceNode497 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPT_TraceNode518 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceNode532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbNode_in_parse_ASPT_TraceNode551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_parse_ASPT_TraceProp576 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPT_TraceProp590 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceProp608 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceProp629 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceProp647 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceProp668 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceProp686 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceProp707 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceProp725 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceProp746 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceProp764 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceProp785 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceProp803 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceProp824 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceProp842 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPT_TraceProp863 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceProp877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbProp_in_parse_ASPT_TraceProp896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceEdge921 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPT_TraceEdge935 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceEdge953 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceEdge974 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceEdge992 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceEdge1013 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceEdge1031 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceEdge1052 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceEdge1070 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceEdge1091 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceEdge1109 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceEdge1130 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceEdge1148 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceEdge1169 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceEdge1187 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceEdge1208 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceEdge1226 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPT_TraceEdge1247 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceEdge1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbEdge_in_parse_ASPT_TraceEdge1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_ASPT_TraceNbEdge1305 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPT_TraceNbEdge1319 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceNbEdge1337 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbEdge1358 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceNbEdge1376 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbEdge1397 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNbEdge1415 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbEdge1436 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceNbEdge1454 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbEdge1475 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceNbEdge1493 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbEdge1514 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNbEdge1532 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbEdge1553 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceNbEdge1571 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbEdge1592 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNbEdge1610 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPT_TraceNbEdge1631 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceNbEdge1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_ASPT_TraceNbProp1674 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPT_TraceNbProp1688 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceNbProp1706 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbProp1727 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceNbProp1745 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbProp1766 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNbProp1784 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbProp1805 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceNbProp1823 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbProp1844 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNbProp1862 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbProp1883 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceNbProp1901 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbProp1922 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNbProp1940 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPT_TraceNbProp1961 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceNbProp1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_ASPT_TraceNbNode2004 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPT_TraceNbNode2018 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceNbNode2036 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbNode2057 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceNbNode2075 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbNode2096 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceNbNode2114 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceNbNode2135 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceNbNode2153 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPT_TraceNbNode2174 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceNbNode2188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parse_ASPT_TraceLink2217 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPT_TraceLink2231 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceLink2249 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceLink2270 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceLink2288 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceLink2309 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceLink2327 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceLink2348 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceLink2366 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceLink2387 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceLink2405 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceLink2426 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPT_TraceLink2444 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPT_TraceLink2465 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPT_TraceLink2483 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPT_TraceLink2504 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceLink2518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNode_in_parse_ASPT_TraceElement2543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceProp_in_parse_ASPT_TraceElement2553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceEdge_in_parse_ASPT_TraceElement2563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbEdge_in_parse_ASPT_TraceElement2573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbProp_in_parse_ASPT_TraceElement2583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbNode_in_parse_ASPT_TraceElement2593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceLink_in_parse_ASPT_TraceElement2603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceElement_in_synpred1_Aspt250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNode_in_synpred6_Aspt2543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceProp_in_synpred7_Aspt2553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceEdge_in_synpred8_Aspt2563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbEdge_in_synpred9_Aspt2573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbProp_in_synpred10_Aspt2583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbNode_in_synpred11_Aspt2593 = new BitSet(new long[]{0x0000000000000002L});

}