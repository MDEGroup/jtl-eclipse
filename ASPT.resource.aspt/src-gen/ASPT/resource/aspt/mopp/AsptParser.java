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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FLOAT", "IDENTIFIER", "INTEGER", "LINEBREAK", "QUOTED_34_34", "SL_COMMENT", "WHITESPACE", "').'", "','", "'trace_edge('", "'trace_link('", "'trace_model('", "'trace_nb_edge('", "'trace_nb_node('", "'trace_nb_prop('", "'trace_node('", "'trace_prop('"
    };

    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int FLOAT=4;
    public static final int IDENTIFIER=5;
    public static final int INTEGER=6;
    public static final int LINEBREAK=7;
    public static final int QUOTED_34_34=8;
    public static final int SL_COMMENT=9;
    public static final int WHITESPACE=10;

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
    		int followSetID = 102;
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
    // Aspt.g:536:1: parse_ASPT_TraceModel returns [ASPT.TraceModel element = null] : a0= 'trace_model(' (a1= QUOTED_34_34 ) a2= ',' (a3= IDENTIFIER ) a4= ').' ( ( (a5_0= parse_ASPT_TraceElement ) | (a6_0= parse_ASPT_TraceLink ) ) )* ;
    public final ASPT.TraceModel parse_ASPT_TraceModel() throws RecognitionException {
        ASPT.TraceModel element =  null;

        int parse_ASPT_TraceModel_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        ASPT.TraceElement a5_0 =null;

        ASPT.TraceLink a6_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Aspt.g:539:2: (a0= 'trace_model(' (a1= QUOTED_34_34 ) a2= ',' (a3= IDENTIFIER ) a4= ').' ( ( (a5_0= parse_ASPT_TraceElement ) | (a6_0= parse_ASPT_TraceLink ) ) )* )
            // Aspt.g:540:2: a0= 'trace_model(' (a1= QUOTED_34_34 ) a2= ',' (a3= IDENTIFIER ) a4= ').' ( ( (a5_0= parse_ASPT_TraceElement ) | (a6_0= parse_ASPT_TraceLink ) ) )*
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_ASPT_TraceModel115); if (state.failed) return element;

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

            // Aspt.g:554:2: (a1= QUOTED_34_34 )
            // Aspt.g:555:3: a1= QUOTED_34_34
            {
            a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceModel133); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__ID), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__ID), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[2]);
            	}

            a2=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceModel154); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[3]);
            	}

            // Aspt.g:604:2: (a3= IDENTIFIER )
            // Aspt.g:605:3: a3= IDENTIFIER
            {
            a3=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_ASPT_TraceModel172); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__MMS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__MMS), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_3, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[4]);
            	}

            a4=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceModel193); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[6]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[7]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[8]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[10]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[11]);
            	}

            // Aspt.g:660:2: ( ( (a5_0= parse_ASPT_TraceElement ) | (a6_0= parse_ASPT_TraceLink ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= 13 && LA2_0 <= 14)||(LA2_0 >= 16 && LA2_0 <= 20)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Aspt.g:661:3: ( (a5_0= parse_ASPT_TraceElement ) | (a6_0= parse_ASPT_TraceLink ) )
            	    {
            	    // Aspt.g:661:3: ( (a5_0= parse_ASPT_TraceElement ) | (a6_0= parse_ASPT_TraceLink ) )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==13||(LA1_0 >= 16 && LA1_0 <= 20)) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==14) ) {
            	        int LA1_2 = input.LA(2);

            	        if ( (LA1_2==IDENTIFIER) ) {
            	            int LA1_3 = input.LA(3);

            	            if ( (LA1_3==12) ) {
            	                int LA1_4 = input.LA(4);

            	                if ( (LA1_4==INTEGER) ) {
            	                    int LA1_5 = input.LA(5);

            	                    if ( (LA1_5==12) ) {
            	                        int LA1_6 = input.LA(6);

            	                        if ( (LA1_6==QUOTED_34_34) ) {
            	                            int LA1_7 = input.LA(7);

            	                            if ( (LA1_7==12) ) {
            	                                int LA1_8 = input.LA(8);

            	                                if ( (LA1_8==IDENTIFIER) ) {
            	                                    int LA1_9 = input.LA(9);

            	                                    if ( (LA1_9==12) ) {
            	                                        int LA1_10 = input.LA(10);

            	                                        if ( (LA1_10==QUOTED_34_34) ) {
            	                                            int LA1_11 = input.LA(11);

            	                                            if ( (LA1_11==11) ) {
            	                                                int LA1_12 = input.LA(12);

            	                                                if ( (synpred1_Aspt()) ) {
            	                                                    alt1=1;
            	                                                }
            	                                                else if ( (true) ) {
            	                                                    alt1=2;
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
            	            // Aspt.g:662:4: (a5_0= parse_ASPT_TraceElement )
            	            {
            	            // Aspt.g:662:4: (a5_0= parse_ASPT_TraceElement )
            	            // Aspt.g:663:5: a5_0= parse_ASPT_TraceElement
            	            {
            	            pushFollow(FOLLOW_parse_ASPT_TraceElement_in_parse_ASPT_TraceModel222);
            	            a5_0=parse_ASPT_TraceElement();

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
            	            					if (a5_0 != null) {
            	            						if (a5_0 != null) {
            	            							Object value = a5_0;
            	            							addObjectToList(element, ASPT.ASPTPackage.TRACE_MODEL__TRACEELEMENTS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_5_0_0_0, a5_0, true);
            	            						copyLocalizationInfos(a5_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[12]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[13]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[14]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[15]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[16]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[17]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[18]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Aspt.g:695:8: (a6_0= parse_ASPT_TraceLink )
            	            {
            	            // Aspt.g:695:8: (a6_0= parse_ASPT_TraceLink )
            	            // Aspt.g:696:5: a6_0= parse_ASPT_TraceLink
            	            {
            	            pushFollow(FOLLOW_parse_ASPT_TraceLink_in_parse_ASPT_TraceModel264);
            	            a6_0=parse_ASPT_TraceLink();

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
            	            					if (a6_0 != null) {
            	            						if (a6_0 != null) {
            	            							Object value = a6_0;
            	            							addObjectToList(element, ASPT.ASPTPackage.TRACE_MODEL__TRACELINKS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_5_0_1_0, a6_0, true);
            	            						copyLocalizationInfos(a6_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[19]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[20]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[21]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[22]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[23]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[24]);
            	            				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[25]);
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
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[27]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[28]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[29]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[30]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[31]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[32]);
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
    // Aspt.g:742:1: parse_ASPT_TraceNode returns [ASPT.TraceNode element = null] : (a0= 'trace_node(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= IDENTIFIER ) a8= ').' |c0= parse_ASPT_TraceNbNode );
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
        ASPT.TraceNbNode c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Aspt.g:745:2: (a0= 'trace_node(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= IDENTIFIER ) a8= ').' |c0= parse_ASPT_TraceNbNode )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==19) ) {
                alt3=1;
            }
            else if ( (LA3_0==17) ) {
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
                    // Aspt.g:746:2: a0= 'trace_node(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= IDENTIFIER ) a8= ').'
                    {
                    a0=(Token)match(input,19,FOLLOW_19_in_parse_ASPT_TraceNode320); if (state.failed) return element;

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
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[33]);
                    	}

                    // Aspt.g:760:2: (a1= IDENTIFIER )
                    // Aspt.g:761:3: a1= IDENTIFIER
                    {
                    a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNode338); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    				startIncompleteElement(element);
                    			}
                    			if (a1 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__METAMODEL), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__METAMODEL), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_1, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[34]);
                    	}

                    a2=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNode359); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_2, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[35]);
                    	}

                    // Aspt.g:810:2: (a3= INTEGER )
                    // Aspt.g:811:3: a3= INTEGER
                    {
                    a3=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_ASPT_TraceNode377); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    				startIncompleteElement(element);
                    			}
                    			if (a3 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__ID), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__ID), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_3, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[36]);
                    	}

                    a4=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNode398); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_4, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[37]);
                    	}

                    // Aspt.g:860:2: (a5= QUOTED_34_34 )
                    // Aspt.g:861:3: a5= QUOTED_34_34
                    {
                    a5=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNode416); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    				startIncompleteElement(element);
                    			}
                    			if (a5 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__IDX), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__IDX), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_5, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[38]);
                    	}

                    a6=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNode437); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_6, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[39]);
                    	}

                    // Aspt.g:910:2: (a7= IDENTIFIER )
                    // Aspt.g:911:3: a7= IDENTIFIER
                    {
                    a7=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNode455); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    				startIncompleteElement(element);
                    			}
                    			if (a7 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__TYPE), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__TYPE), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_7, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[40]);
                    	}

                    a8=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceNode476); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_8, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[41]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[42]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[43]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[44]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[45]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[46]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[47]);
                    	}

                    }
                    break;
                case 2 :
                    // Aspt.g:968:2: c0= parse_ASPT_TraceNbNode
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceNbNode_in_parse_ASPT_TraceNode495);
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
    // Aspt.g:972:1: parse_ASPT_TraceProp returns [ASPT.TraceProp element = null] : (a0= 'trace_prop(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= INTEGER ) a8= ',' (a9= QUOTED_34_34 ) a10= ',' (a11= IDENTIFIER ) a12= ',' (a13= QUOTED_34_34 ) a14= ').' |c0= parse_ASPT_TraceNbProp );
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
        ASPT.TraceNbProp c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Aspt.g:975:2: (a0= 'trace_prop(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= INTEGER ) a8= ',' (a9= QUOTED_34_34 ) a10= ',' (a11= IDENTIFIER ) a12= ',' (a13= QUOTED_34_34 ) a14= ').' |c0= parse_ASPT_TraceNbProp )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            else if ( (LA4_0==18) ) {
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
                    // Aspt.g:976:2: a0= 'trace_prop(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= INTEGER ) a8= ',' (a9= QUOTED_34_34 ) a10= ',' (a11= IDENTIFIER ) a12= ',' (a13= QUOTED_34_34 ) a14= ').'
                    {
                    a0=(Token)match(input,20,FOLLOW_20_in_parse_ASPT_TraceProp520); if (state.failed) return element;

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
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[48]);
                    	}

                    // Aspt.g:990:2: (a1= IDENTIFIER )
                    // Aspt.g:991:3: a1= IDENTIFIER
                    {
                    a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_ASPT_TraceProp538); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    				startIncompleteElement(element);
                    			}
                    			if (a1 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__METAMODEL), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__METAMODEL), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_1, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[49]);
                    	}

                    a2=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceProp559); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_2, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[50]);
                    	}

                    // Aspt.g:1040:2: (a3= INTEGER )
                    // Aspt.g:1041:3: a3= INTEGER
                    {
                    a3=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_ASPT_TraceProp577); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    				startIncompleteElement(element);
                    			}
                    			if (a3 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__ID), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__ID), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_3, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[51]);
                    	}

                    a4=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceProp598); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_4, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[52]);
                    	}

                    // Aspt.g:1090:2: (a5= QUOTED_34_34 )
                    // Aspt.g:1091:3: a5= QUOTED_34_34
                    {
                    a5=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceProp616); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    				startIncompleteElement(element);
                    			}
                    			if (a5 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDX), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDX), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_5, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[53]);
                    	}

                    a6=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceProp637); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_6, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[54]);
                    	}

                    // Aspt.g:1140:2: (a7= INTEGER )
                    // Aspt.g:1141:3: a7= INTEGER
                    {
                    a7=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_ASPT_TraceProp655); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    				startIncompleteElement(element);
                    			}
                    			if (a7 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDP), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDP), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_7, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[55]);
                    	}

                    a8=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceProp676); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_8, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[56]);
                    	}

                    // Aspt.g:1190:2: (a9= QUOTED_34_34 )
                    // Aspt.g:1191:3: a9= QUOTED_34_34
                    {
                    a9=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceProp694); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    				startIncompleteElement(element);
                    			}
                    			if (a9 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDPX), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDPX), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_9, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[57]);
                    	}

                    a10=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceProp715); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_10, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[58]);
                    	}

                    // Aspt.g:1240:2: (a11= IDENTIFIER )
                    // Aspt.g:1241:3: a11= IDENTIFIER
                    {
                    a11=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_ASPT_TraceProp733); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    				startIncompleteElement(element);
                    			}
                    			if (a11 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__TYPE), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a11).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__TYPE), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_11, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a11, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[59]);
                    	}

                    a12=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceProp754); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_12, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[60]);
                    	}

                    // Aspt.g:1290:2: (a13= QUOTED_34_34 )
                    // Aspt.g:1291:3: a13= QUOTED_34_34
                    {
                    a13=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceProp772); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    				startIncompleteElement(element);
                    			}
                    			if (a13 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__VALUE), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a13).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__VALUE), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_13, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a13, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[61]);
                    	}

                    a14=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceProp793); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_14, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[62]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[63]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[64]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[65]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[66]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[67]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[68]);
                    	}

                    }
                    break;
                case 2 :
                    // Aspt.g:1348:2: c0= parse_ASPT_TraceNbProp
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceNbProp_in_parse_ASPT_TraceProp812);
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
    // Aspt.g:1352:1: parse_ASPT_TraceEdge returns [ASPT.TraceEdge element = null] : (a0= 'trace_edge(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= IDENTIFIER ) a8= ',' (a9= INTEGER ) a10= ',' (a11= QUOTED_34_34 ) a12= ',' (a13= INTEGER ) a14= ',' (a15= QUOTED_34_34 ) a16= ').' |c0= parse_ASPT_TraceNbEdge );
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
        ASPT.TraceNbEdge c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Aspt.g:1355:2: (a0= 'trace_edge(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= IDENTIFIER ) a8= ',' (a9= INTEGER ) a10= ',' (a11= QUOTED_34_34 ) a12= ',' (a13= INTEGER ) a14= ',' (a15= QUOTED_34_34 ) a16= ').' |c0= parse_ASPT_TraceNbEdge )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            else if ( (LA5_0==16) ) {
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
                    // Aspt.g:1356:2: a0= 'trace_edge(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= IDENTIFIER ) a8= ',' (a9= INTEGER ) a10= ',' (a11= QUOTED_34_34 ) a12= ',' (a13= INTEGER ) a14= ',' (a15= QUOTED_34_34 ) a16= ').'
                    {
                    a0=(Token)match(input,13,FOLLOW_13_in_parse_ASPT_TraceEdge837); if (state.failed) return element;

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
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[69]);
                    	}

                    // Aspt.g:1370:2: (a1= IDENTIFIER )
                    // Aspt.g:1371:3: a1= IDENTIFIER
                    {
                    a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_ASPT_TraceEdge855); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a1 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__METAMODEL), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__METAMODEL), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_1, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[70]);
                    	}

                    a2=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceEdge876); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_2, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[71]);
                    	}

                    // Aspt.g:1420:2: (a3= INTEGER )
                    // Aspt.g:1421:3: a3= INTEGER
                    {
                    a3=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_ASPT_TraceEdge894); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a3 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__ID), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__ID), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_3, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[72]);
                    	}

                    a4=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceEdge915); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_4, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[73]);
                    	}

                    // Aspt.g:1470:2: (a5= QUOTED_34_34 )
                    // Aspt.g:1471:3: a5= QUOTED_34_34
                    {
                    a5=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceEdge933); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a5 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDX), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDX), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_5, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[74]);
                    	}

                    a6=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceEdge954); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_6, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[75]);
                    	}

                    // Aspt.g:1520:2: (a7= IDENTIFIER )
                    // Aspt.g:1521:3: a7= IDENTIFIER
                    {
                    a7=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_ASPT_TraceEdge972); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a7 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__TYPE), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__TYPE), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_7, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[76]);
                    	}

                    a8=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceEdge993); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_8, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[77]);
                    	}

                    // Aspt.g:1570:2: (a9= INTEGER )
                    // Aspt.g:1571:3: a9= INTEGER
                    {
                    a9=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_ASPT_TraceEdge1011); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a9 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDS), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDS), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_9, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[78]);
                    	}

                    a10=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceEdge1032); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_10, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[79]);
                    	}

                    // Aspt.g:1620:2: (a11= QUOTED_34_34 )
                    // Aspt.g:1621:3: a11= QUOTED_34_34
                    {
                    a11=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceEdge1050); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a11 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDSX), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a11).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDSX), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_11, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a11, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[80]);
                    	}

                    a12=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceEdge1071); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_12, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[81]);
                    	}

                    // Aspt.g:1670:2: (a13= INTEGER )
                    // Aspt.g:1671:3: a13= INTEGER
                    {
                    a13=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_ASPT_TraceEdge1089); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a13 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDT), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a13).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDT), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_13, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a13, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[82]);
                    	}

                    a14=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceEdge1110); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_14, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[83]);
                    	}

                    // Aspt.g:1720:2: (a15= QUOTED_34_34 )
                    // Aspt.g:1721:3: a15= QUOTED_34_34
                    {
                    a15=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceEdge1128); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    				startIncompleteElement(element);
                    			}
                    			if (a15 != null) {
                    				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    				tokenResolver.setOptions(getOptions());
                    				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
                    				tokenResolver.resolve(a15.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDTX), result);
                    				Object resolvedObject = result.getResolvedToken();
                    				if (resolvedObject == null) {
                    					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a15).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a15).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a15).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a15).getStopIndex());
                    				}
                    				java.lang.String resolved = (java.lang.String) resolvedObject;
                    				if (resolved != null) {
                    					Object value = resolved;
                    					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDTX), value);
                    					completedElement(value, false);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_15, resolved, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a15, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[84]);
                    	}

                    a16=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceEdge1149); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_16, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[85]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[86]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[87]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[88]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[89]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[90]);
                    		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[91]);
                    	}

                    }
                    break;
                case 2 :
                    // Aspt.g:1778:2: c0= parse_ASPT_TraceNbEdge
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceNbEdge_in_parse_ASPT_TraceEdge1168);
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
    // Aspt.g:1782:1: parse_ASPT_TraceNbEdge returns [ASPT.TraceNbEdge element = null] : a0= 'trace_nb_edge(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= IDENTIFIER ) a8= ',' (a9= INTEGER ) a10= ',' (a11= QUOTED_34_34 ) a12= ',' (a13= INTEGER ) a14= ',' (a15= QUOTED_34_34 ) a16= ').' ;
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



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Aspt.g:1785:2: (a0= 'trace_nb_edge(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= IDENTIFIER ) a8= ',' (a9= INTEGER ) a10= ',' (a11= QUOTED_34_34 ) a12= ',' (a13= INTEGER ) a14= ',' (a15= QUOTED_34_34 ) a16= ').' )
            // Aspt.g:1786:2: a0= 'trace_nb_edge(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= IDENTIFIER ) a8= ',' (a9= INTEGER ) a10= ',' (a11= QUOTED_34_34 ) a12= ',' (a13= INTEGER ) a14= ',' (a15= QUOTED_34_34 ) a16= ').'
            {
            a0=(Token)match(input,16,FOLLOW_16_in_parse_ASPT_TraceNbEdge1193); if (state.failed) return element;

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
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[92]);
            	}

            // Aspt.g:1800:2: (a1= IDENTIFIER )
            // Aspt.g:1801:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNbEdge1211); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__METAMODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__METAMODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[93]);
            	}

            a2=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbEdge1232); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[94]);
            	}

            // Aspt.g:1850:2: (a3= INTEGER )
            // Aspt.g:1851:3: a3= INTEGER
            {
            a3=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_ASPT_TraceNbEdge1250); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__ID), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__ID), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_3, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[95]);
            	}

            a4=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbEdge1271); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[96]);
            	}

            // Aspt.g:1900:2: (a5= QUOTED_34_34 )
            // Aspt.g:1901:3: a5= QUOTED_34_34
            {
            a5=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNbEdge1289); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a5 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_5, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[97]);
            	}

            a6=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbEdge1310); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[98]);
            	}

            // Aspt.g:1950:2: (a7= IDENTIFIER )
            // Aspt.g:1951:3: a7= IDENTIFIER
            {
            a7=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNbEdge1328); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a7 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__TYPE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__TYPE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_7, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[99]);
            	}

            a8=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbEdge1349); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_8, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[100]);
            	}

            // Aspt.g:2000:2: (a9= INTEGER )
            // Aspt.g:2001:3: a9= INTEGER
            {
            a9=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_ASPT_TraceNbEdge1367); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a9 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDS), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_9, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[101]);
            	}

            a10=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbEdge1388); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_10, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[102]);
            	}

            // Aspt.g:2050:2: (a11= QUOTED_34_34 )
            // Aspt.g:2051:3: a11= QUOTED_34_34
            {
            a11=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNbEdge1406); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a11 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDSX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a11).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDSX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_11, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a11, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[103]);
            	}

            a12=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbEdge1427); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_12, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[104]);
            	}

            // Aspt.g:2100:2: (a13= INTEGER )
            // Aspt.g:2101:3: a13= INTEGER
            {
            a13=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_ASPT_TraceNbEdge1445); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a13 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a13).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_13, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a13, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[105]);
            	}

            a14=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbEdge1466); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_14, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[106]);
            	}

            // Aspt.g:2150:2: (a15= QUOTED_34_34 )
            // Aspt.g:2151:3: a15= QUOTED_34_34
            {
            a15=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNbEdge1484); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            				startIncompleteElement(element);
            			}
            			if (a15 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a15.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDTX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a15).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a15).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a15).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a15).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDTX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_15, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a15, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[107]);
            	}

            a16=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceNbEdge1505); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_16, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[108]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[109]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[110]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[111]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[112]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[113]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[114]);
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
    // Aspt.g:2208:1: parse_ASPT_TraceNbProp returns [ASPT.TraceNbProp element = null] : a0= 'trace_nb_prop(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= INTEGER ) a8= ',' (a9= QUOTED_34_34 ) a10= ',' (a11= IDENTIFIER ) a12= ',' (a13= QUOTED_34_34 ) a14= ').' ;
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



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Aspt.g:2211:2: (a0= 'trace_nb_prop(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= INTEGER ) a8= ',' (a9= QUOTED_34_34 ) a10= ',' (a11= IDENTIFIER ) a12= ',' (a13= QUOTED_34_34 ) a14= ').' )
            // Aspt.g:2212:2: a0= 'trace_nb_prop(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= INTEGER ) a8= ',' (a9= QUOTED_34_34 ) a10= ',' (a11= IDENTIFIER ) a12= ',' (a13= QUOTED_34_34 ) a14= ').'
            {
            a0=(Token)match(input,18,FOLLOW_18_in_parse_ASPT_TraceNbProp1534); if (state.failed) return element;

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
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[115]);
            	}

            // Aspt.g:2226:2: (a1= IDENTIFIER )
            // Aspt.g:2227:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNbProp1552); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__METAMODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__METAMODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[116]);
            	}

            a2=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbProp1573); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[117]);
            	}

            // Aspt.g:2276:2: (a3= INTEGER )
            // Aspt.g:2277:3: a3= INTEGER
            {
            a3=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_ASPT_TraceNbProp1591); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__ID), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__ID), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_3, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[118]);
            	}

            a4=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbProp1612); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[119]);
            	}

            // Aspt.g:2326:2: (a5= QUOTED_34_34 )
            // Aspt.g:2327:3: a5= QUOTED_34_34
            {
            a5=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNbProp1630); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            				startIncompleteElement(element);
            			}
            			if (a5 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_5, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[120]);
            	}

            a6=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbProp1651); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[121]);
            	}

            // Aspt.g:2376:2: (a7= INTEGER )
            // Aspt.g:2377:3: a7= INTEGER
            {
            a7=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_ASPT_TraceNbProp1669); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            				startIncompleteElement(element);
            			}
            			if (a7 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDP), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDP), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_7, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[122]);
            	}

            a8=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbProp1690); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_8, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[123]);
            	}

            // Aspt.g:2426:2: (a9= QUOTED_34_34 )
            // Aspt.g:2427:3: a9= QUOTED_34_34
            {
            a9=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNbProp1708); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            				startIncompleteElement(element);
            			}
            			if (a9 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDPX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDPX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_9, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[124]);
            	}

            a10=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbProp1729); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_10, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[125]);
            	}

            // Aspt.g:2476:2: (a11= IDENTIFIER )
            // Aspt.g:2477:3: a11= IDENTIFIER
            {
            a11=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNbProp1747); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            				startIncompleteElement(element);
            			}
            			if (a11 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__TYPE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a11).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__TYPE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_11, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a11, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[126]);
            	}

            a12=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbProp1768); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_12, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[127]);
            	}

            // Aspt.g:2526:2: (a13= QUOTED_34_34 )
            // Aspt.g:2527:3: a13= QUOTED_34_34
            {
            a13=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNbProp1786); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            				startIncompleteElement(element);
            			}
            			if (a13 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__VALUE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a13).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__VALUE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_13, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a13, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[128]);
            	}

            a14=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceNbProp1807); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_14, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[129]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[130]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[131]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[132]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[133]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[134]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[135]);
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
    // Aspt.g:2584:1: parse_ASPT_TraceNbNode returns [ASPT.TraceNbNode element = null] : a0= 'trace_nb_node(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= IDENTIFIER ) a8= ').' ;
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



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Aspt.g:2587:2: (a0= 'trace_nb_node(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= IDENTIFIER ) a8= ').' )
            // Aspt.g:2588:2: a0= 'trace_nb_node(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= IDENTIFIER ) a8= ').'
            {
            a0=(Token)match(input,17,FOLLOW_17_in_parse_ASPT_TraceNbNode1836); if (state.failed) return element;

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
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[136]);
            	}

            // Aspt.g:2602:2: (a1= IDENTIFIER )
            // Aspt.g:2603:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNbNode1854); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__METAMODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__METAMODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[137]);
            	}

            a2=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbNode1875); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[138]);
            	}

            // Aspt.g:2652:2: (a3= INTEGER )
            // Aspt.g:2653:3: a3= INTEGER
            {
            a3=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_ASPT_TraceNbNode1893); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__ID), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__ID), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_3, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[139]);
            	}

            a4=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbNode1914); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[140]);
            	}

            // Aspt.g:2702:2: (a5= QUOTED_34_34 )
            // Aspt.g:2703:3: a5= QUOTED_34_34
            {
            a5=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNbNode1932); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            				startIncompleteElement(element);
            			}
            			if (a5 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__IDX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__IDX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_5, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[141]);
            	}

            a6=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceNbNode1953); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[142]);
            	}

            // Aspt.g:2752:2: (a7= IDENTIFIER )
            // Aspt.g:2753:3: a7= IDENTIFIER
            {
            a7=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNbNode1971); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            				startIncompleteElement(element);
            			}
            			if (a7 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__TYPE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__TYPE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_7, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[143]);
            	}

            a8=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceNbNode1992); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_8, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[144]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[145]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[146]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[147]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[148]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[149]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[150]);
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
    // Aspt.g:2810:1: parse_ASPT_TraceLink returns [ASPT.TraceLink element = null] : a0= 'trace_link(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= IDENTIFIER ) a8= ',' (a9= QUOTED_34_34 ) a10= ').' ;
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



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Aspt.g:2813:2: (a0= 'trace_link(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= IDENTIFIER ) a8= ',' (a9= QUOTED_34_34 ) a10= ').' )
            // Aspt.g:2814:2: a0= 'trace_link(' (a1= IDENTIFIER ) a2= ',' (a3= INTEGER ) a4= ',' (a5= QUOTED_34_34 ) a6= ',' (a7= IDENTIFIER ) a8= ',' (a9= QUOTED_34_34 ) a10= ').'
            {
            a0=(Token)match(input,14,FOLLOW_14_in_parse_ASPT_TraceLink2021); if (state.failed) return element;

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
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[151]);
            	}

            // Aspt.g:2828:2: (a1= IDENTIFIER )
            // Aspt.g:2829:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_ASPT_TraceLink2039); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__METAMODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__METAMODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[152]);
            	}

            a2=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceLink2060); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[153]);
            	}

            // Aspt.g:2878:2: (a3= INTEGER )
            // Aspt.g:2879:3: a3= INTEGER
            {
            a3=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_ASPT_TraceLink2078); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__ID), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__ID), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_3, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[154]);
            	}

            a4=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceLink2099); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[155]);
            	}

            // Aspt.g:2928:2: (a5= QUOTED_34_34 )
            // Aspt.g:2929:3: a5= QUOTED_34_34
            {
            a5=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceLink2117); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            				startIncompleteElement(element);
            			}
            			if (a5 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_5, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[156]);
            	}

            a6=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceLink2138); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[157]);
            	}

            // Aspt.g:2978:2: (a7= IDENTIFIER )
            // Aspt.g:2979:3: a7= IDENTIFIER
            {
            a7=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_ASPT_TraceLink2156); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            				startIncompleteElement(element);
            			}
            			if (a7 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__TYPE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__TYPE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_7, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[158]);
            	}

            a8=(Token)match(input,12,FOLLOW_12_in_parse_ASPT_TraceLink2177); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_8, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[159]);
            	}

            // Aspt.g:3028:2: (a9= QUOTED_34_34 )
            // Aspt.g:3029:3: a9= QUOTED_34_34
            {
            a9=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceLink2195); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPT.resource.aspt.mopp.AsptTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            				startIncompleteElement(element);
            			}
            			if (a9 != null) {
            				ASPT.resource.aspt.IAsptTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				ASPT.resource.aspt.IAsptTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__RELATION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__RELATION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_9, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[160]);
            	}

            a10=(Token)match(input,11,FOLLOW_11_in_parse_ASPT_TraceLink2216); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_10, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[161]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[162]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[163]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[164]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[165]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[166]);
            		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[167]);
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
    // Aspt.g:3086:1: parse_ASPT_TraceElement returns [ASPT.TraceElement element = null] : (c0= parse_ASPT_TraceNode |c1= parse_ASPT_TraceProp |c2= parse_ASPT_TraceEdge |c3= parse_ASPT_TraceNbEdge |c4= parse_ASPT_TraceNbProp |c5= parse_ASPT_TraceNbNode |c6= parse_ASPT_TraceLink );
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

            // Aspt.g:3087:2: (c0= parse_ASPT_TraceNode |c1= parse_ASPT_TraceProp |c2= parse_ASPT_TraceEdge |c3= parse_ASPT_TraceNbEdge |c4= parse_ASPT_TraceNbProp |c5= parse_ASPT_TraceNbNode |c6= parse_ASPT_TraceLink )
            int alt6=7;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt6=1;
                }
                break;
            case 17:
                {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==IDENTIFIER) ) {
                    int LA6_8 = input.LA(3);

                    if ( (LA6_8==12) ) {
                        int LA6_11 = input.LA(4);

                        if ( (LA6_11==INTEGER) ) {
                            int LA6_14 = input.LA(5);

                            if ( (LA6_14==12) ) {
                                int LA6_17 = input.LA(6);

                                if ( (LA6_17==QUOTED_34_34) ) {
                                    int LA6_20 = input.LA(7);

                                    if ( (LA6_20==12) ) {
                                        int LA6_23 = input.LA(8);

                                        if ( (LA6_23==IDENTIFIER) ) {
                                            int LA6_26 = input.LA(9);

                                            if ( (LA6_26==11) ) {
                                                int LA6_29 = input.LA(10);

                                                if ( (synpred6_Aspt()) ) {
                                                    alt6=1;
                                                }
                                                else if ( (synpred11_Aspt()) ) {
                                                    alt6=6;
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
            case 20:
                {
                alt6=2;
                }
                break;
            case 18:
                {
                int LA6_4 = input.LA(2);

                if ( (LA6_4==IDENTIFIER) ) {
                    int LA6_9 = input.LA(3);

                    if ( (LA6_9==12) ) {
                        int LA6_12 = input.LA(4);

                        if ( (LA6_12==INTEGER) ) {
                            int LA6_15 = input.LA(5);

                            if ( (LA6_15==12) ) {
                                int LA6_18 = input.LA(6);

                                if ( (LA6_18==QUOTED_34_34) ) {
                                    int LA6_21 = input.LA(7);

                                    if ( (LA6_21==12) ) {
                                        int LA6_24 = input.LA(8);

                                        if ( (LA6_24==INTEGER) ) {
                                            int LA6_27 = input.LA(9);

                                            if ( (LA6_27==12) ) {
                                                int LA6_30 = input.LA(10);

                                                if ( (LA6_30==QUOTED_34_34) ) {
                                                    int LA6_33 = input.LA(11);

                                                    if ( (LA6_33==12) ) {
                                                        int LA6_35 = input.LA(12);

                                                        if ( (LA6_35==IDENTIFIER) ) {
                                                            int LA6_37 = input.LA(13);

                                                            if ( (LA6_37==12) ) {
                                                                int LA6_39 = input.LA(14);

                                                                if ( (LA6_39==QUOTED_34_34) ) {
                                                                    int LA6_41 = input.LA(15);

                                                                    if ( (LA6_41==11) ) {
                                                                        int LA6_43 = input.LA(16);

                                                                        if ( (synpred7_Aspt()) ) {
                                                                            alt6=2;
                                                                        }
                                                                        else if ( (synpred10_Aspt()) ) {
                                                                            alt6=5;
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
                                                                    new NoViableAltException("", 6, 37, input);

                                                                throw nvae;

                                                            }
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
            case 13:
                {
                alt6=3;
                }
                break;
            case 16:
                {
                int LA6_6 = input.LA(2);

                if ( (LA6_6==IDENTIFIER) ) {
                    int LA6_10 = input.LA(3);

                    if ( (LA6_10==12) ) {
                        int LA6_13 = input.LA(4);

                        if ( (LA6_13==INTEGER) ) {
                            int LA6_16 = input.LA(5);

                            if ( (LA6_16==12) ) {
                                int LA6_19 = input.LA(6);

                                if ( (LA6_19==QUOTED_34_34) ) {
                                    int LA6_22 = input.LA(7);

                                    if ( (LA6_22==12) ) {
                                        int LA6_25 = input.LA(8);

                                        if ( (LA6_25==IDENTIFIER) ) {
                                            int LA6_28 = input.LA(9);

                                            if ( (LA6_28==12) ) {
                                                int LA6_31 = input.LA(10);

                                                if ( (LA6_31==INTEGER) ) {
                                                    int LA6_34 = input.LA(11);

                                                    if ( (LA6_34==12) ) {
                                                        int LA6_36 = input.LA(12);

                                                        if ( (LA6_36==QUOTED_34_34) ) {
                                                            int LA6_38 = input.LA(13);

                                                            if ( (LA6_38==12) ) {
                                                                int LA6_40 = input.LA(14);

                                                                if ( (LA6_40==INTEGER) ) {
                                                                    int LA6_42 = input.LA(15);

                                                                    if ( (LA6_42==12) ) {
                                                                        int LA6_44 = input.LA(16);

                                                                        if ( (LA6_44==QUOTED_34_34) ) {
                                                                            int LA6_46 = input.LA(17);

                                                                            if ( (LA6_46==11) ) {
                                                                                int LA6_47 = input.LA(18);

                                                                                if ( (synpred8_Aspt()) ) {
                                                                                    alt6=3;
                                                                                }
                                                                                else if ( (synpred9_Aspt()) ) {
                                                                                    alt6=4;
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
                                                                    new NoViableAltException("", 6, 38, input);

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
            case 14:
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
                    // Aspt.g:3088:2: c0= parse_ASPT_TraceNode
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceNode_in_parse_ASPT_TraceElement2241);
                    c0=parse_ASPT_TraceNode();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Aspt.g:3089:4: c1= parse_ASPT_TraceProp
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceProp_in_parse_ASPT_TraceElement2251);
                    c1=parse_ASPT_TraceProp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Aspt.g:3090:4: c2= parse_ASPT_TraceEdge
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceEdge_in_parse_ASPT_TraceElement2261);
                    c2=parse_ASPT_TraceEdge();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Aspt.g:3091:4: c3= parse_ASPT_TraceNbEdge
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceNbEdge_in_parse_ASPT_TraceElement2271);
                    c3=parse_ASPT_TraceNbEdge();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Aspt.g:3092:4: c4= parse_ASPT_TraceNbProp
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceNbProp_in_parse_ASPT_TraceElement2281);
                    c4=parse_ASPT_TraceNbProp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Aspt.g:3093:4: c5= parse_ASPT_TraceNbNode
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceNbNode_in_parse_ASPT_TraceElement2291);
                    c5=parse_ASPT_TraceNbNode();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Aspt.g:3094:4: c6= parse_ASPT_TraceLink
                    {
                    pushFollow(FOLLOW_parse_ASPT_TraceLink_in_parse_ASPT_TraceElement2301);
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
        ASPT.TraceElement a5_0 =null;


        // Aspt.g:662:4: ( (a5_0= parse_ASPT_TraceElement ) )
        // Aspt.g:662:4: (a5_0= parse_ASPT_TraceElement )
        {
        // Aspt.g:662:4: (a5_0= parse_ASPT_TraceElement )
        // Aspt.g:663:5: a5_0= parse_ASPT_TraceElement
        {
        pushFollow(FOLLOW_parse_ASPT_TraceElement_in_synpred1_Aspt222);
        a5_0=parse_ASPT_TraceElement();

        state._fsp--;
        if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred1_Aspt

    // $ANTLR start synpred6_Aspt
    public final void synpred6_Aspt_fragment() throws RecognitionException {
        ASPT.TraceNode c0 =null;


        // Aspt.g:3088:2: (c0= parse_ASPT_TraceNode )
        // Aspt.g:3088:2: c0= parse_ASPT_TraceNode
        {
        pushFollow(FOLLOW_parse_ASPT_TraceNode_in_synpred6_Aspt2241);
        c0=parse_ASPT_TraceNode();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_Aspt

    // $ANTLR start synpred7_Aspt
    public final void synpred7_Aspt_fragment() throws RecognitionException {
        ASPT.TraceProp c1 =null;


        // Aspt.g:3089:4: (c1= parse_ASPT_TraceProp )
        // Aspt.g:3089:4: c1= parse_ASPT_TraceProp
        {
        pushFollow(FOLLOW_parse_ASPT_TraceProp_in_synpred7_Aspt2251);
        c1=parse_ASPT_TraceProp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred7_Aspt

    // $ANTLR start synpred8_Aspt
    public final void synpred8_Aspt_fragment() throws RecognitionException {
        ASPT.TraceEdge c2 =null;


        // Aspt.g:3090:4: (c2= parse_ASPT_TraceEdge )
        // Aspt.g:3090:4: c2= parse_ASPT_TraceEdge
        {
        pushFollow(FOLLOW_parse_ASPT_TraceEdge_in_synpred8_Aspt2261);
        c2=parse_ASPT_TraceEdge();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred8_Aspt

    // $ANTLR start synpred9_Aspt
    public final void synpred9_Aspt_fragment() throws RecognitionException {
        ASPT.TraceNbEdge c3 =null;


        // Aspt.g:3091:4: (c3= parse_ASPT_TraceNbEdge )
        // Aspt.g:3091:4: c3= parse_ASPT_TraceNbEdge
        {
        pushFollow(FOLLOW_parse_ASPT_TraceNbEdge_in_synpred9_Aspt2271);
        c3=parse_ASPT_TraceNbEdge();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred9_Aspt

    // $ANTLR start synpred10_Aspt
    public final void synpred10_Aspt_fragment() throws RecognitionException {
        ASPT.TraceNbProp c4 =null;


        // Aspt.g:3092:4: (c4= parse_ASPT_TraceNbProp )
        // Aspt.g:3092:4: c4= parse_ASPT_TraceNbProp
        {
        pushFollow(FOLLOW_parse_ASPT_TraceNbProp_in_synpred10_Aspt2281);
        c4=parse_ASPT_TraceNbProp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred10_Aspt

    // $ANTLR start synpred11_Aspt
    public final void synpred11_Aspt_fragment() throws RecognitionException {
        ASPT.TraceNbNode c5 =null;


        // Aspt.g:3093:4: (c5= parse_ASPT_TraceNbNode )
        // Aspt.g:3093:4: c5= parse_ASPT_TraceNbNode
        {
        pushFollow(FOLLOW_parse_ASPT_TraceNbNode_in_synpred11_Aspt2291);
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
    public static final BitSet FOLLOW_15_in_parse_ASPT_TraceModel115 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceModel133 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceModel154 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_ASPT_TraceModel172 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceModel193 = new BitSet(new long[]{0x00000000001F6002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceElement_in_parse_ASPT_TraceModel222 = new BitSet(new long[]{0x00000000001F6002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceLink_in_parse_ASPT_TraceModel264 = new BitSet(new long[]{0x00000000001F6002L});
    public static final BitSet FOLLOW_19_in_parse_ASPT_TraceNode320 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNode338 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNode359 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_parse_ASPT_TraceNode377 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNode398 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNode416 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNode437 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNode455 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceNode476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbNode_in_parse_ASPT_TraceNode495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_ASPT_TraceProp520 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_ASPT_TraceProp538 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceProp559 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_parse_ASPT_TraceProp577 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceProp598 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceProp616 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceProp637 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_parse_ASPT_TraceProp655 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceProp676 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceProp694 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceProp715 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_ASPT_TraceProp733 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceProp754 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceProp772 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceProp793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbProp_in_parse_ASPT_TraceProp812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parse_ASPT_TraceEdge837 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_ASPT_TraceEdge855 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceEdge876 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_parse_ASPT_TraceEdge894 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceEdge915 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceEdge933 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceEdge954 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_ASPT_TraceEdge972 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceEdge993 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_parse_ASPT_TraceEdge1011 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceEdge1032 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceEdge1050 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceEdge1071 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_parse_ASPT_TraceEdge1089 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceEdge1110 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceEdge1128 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceEdge1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbEdge_in_parse_ASPT_TraceEdge1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_ASPT_TraceNbEdge1193 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNbEdge1211 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbEdge1232 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_parse_ASPT_TraceNbEdge1250 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbEdge1271 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNbEdge1289 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbEdge1310 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNbEdge1328 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbEdge1349 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_parse_ASPT_TraceNbEdge1367 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbEdge1388 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNbEdge1406 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbEdge1427 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_parse_ASPT_TraceNbEdge1445 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbEdge1466 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNbEdge1484 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceNbEdge1505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_parse_ASPT_TraceNbProp1534 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNbProp1552 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbProp1573 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_parse_ASPT_TraceNbProp1591 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbProp1612 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNbProp1630 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbProp1651 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_parse_ASPT_TraceNbProp1669 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbProp1690 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNbProp1708 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbProp1729 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNbProp1747 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbProp1768 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNbProp1786 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceNbProp1807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_ASPT_TraceNbNode1836 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNbNode1854 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbNode1875 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_parse_ASPT_TraceNbNode1893 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbNode1914 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceNbNode1932 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceNbNode1953 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_ASPT_TraceNbNode1971 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceNbNode1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_ASPT_TraceLink2021 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_ASPT_TraceLink2039 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceLink2060 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_parse_ASPT_TraceLink2078 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceLink2099 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceLink2117 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceLink2138 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_ASPT_TraceLink2156 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASPT_TraceLink2177 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_ASPT_TraceLink2195 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPT_TraceLink2216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNode_in_parse_ASPT_TraceElement2241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceProp_in_parse_ASPT_TraceElement2251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceEdge_in_parse_ASPT_TraceElement2261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbEdge_in_parse_ASPT_TraceElement2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbProp_in_parse_ASPT_TraceElement2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbNode_in_parse_ASPT_TraceElement2291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceLink_in_parse_ASPT_TraceElement2301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceElement_in_synpred1_Aspt222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNode_in_synpred6_Aspt2241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceProp_in_synpred7_Aspt2251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceEdge_in_synpred8_Aspt2261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbEdge_in_synpred9_Aspt2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbProp_in_synpred10_Aspt2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASPT_TraceNbNode_in_synpred11_Aspt2291 = new BitSet(new long[]{0x0000000000000002L});

}