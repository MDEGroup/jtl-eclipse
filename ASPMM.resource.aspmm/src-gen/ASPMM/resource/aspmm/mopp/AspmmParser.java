// $ANTLR 3.4

	package ASPMM.resource.aspmm.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AspmmParser extends AspmmANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LINEBREAK", "TEXT", "WHITESPACE", "'('", "')'", "','", "'.'", "'association'", "'composition'", "'generalization'", "'metaedge'", "'metamodel'", "'metanode'", "'metaprop'"
    };

    public static final int EOF=-1;
    public static final int T__7=7;
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
    public static final int LINEBREAK=4;
    public static final int TEXT=5;
    public static final int WHITESPACE=6;

    // delegates
    public AspmmANTLRParserBase[] getDelegates() {
        return new AspmmANTLRParserBase[] {};
    }

    // delegators


    public AspmmParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public AspmmParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(10 + 1);
         

    }

    public String[] getTokenNames() { return AspmmParser.tokenNames; }
    public String getGrammarFileName() { return "Aspmm.g"; }


    	private ASPMM.resource.aspmm.IAspmmTokenResolverFactory tokenResolverFactory = new ASPMM.resource.aspmm.mopp.AspmmTokenResolverFactory();
    	
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
    	private java.util.List<ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal> expectedElements = new java.util.ArrayList<ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal>();
    	
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
    		postParseCommands.add(new ASPMM.resource.aspmm.IAspmmCommand<ASPMM.resource.aspmm.IAspmmTextResource>() {
    			public boolean execute(ASPMM.resource.aspmm.IAspmmTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new ASPMM.resource.aspmm.IAspmmProblem() {
    					public ASPMM.resource.aspmm.AspmmEProblemSeverity getSeverity() {
    						return ASPMM.resource.aspmm.AspmmEProblemSeverity.ERROR;
    					}
    					public ASPMM.resource.aspmm.AspmmEProblemType getType() {
    						return ASPMM.resource.aspmm.AspmmEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<ASPMM.resource.aspmm.IAspmmQuickFix> getQuickFixes() {
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
    		ASPMM.resource.aspmm.IAspmmExpectedElement terminal = ASPMM.resource.aspmm.grammar.AspmmFollowSetProvider.TERMINALS[terminalID];
    		ASPMM.resource.aspmm.mopp.AspmmContainedFeature[] containmentFeatures = new ASPMM.resource.aspmm.mopp.AspmmContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = ASPMM.resource.aspmm.grammar.AspmmFollowSetProvider.LINKS[ids[i]];
    		}
    		ASPMM.resource.aspmm.grammar.AspmmContainmentTrace containmentTrace = new ASPMM.resource.aspmm.grammar.AspmmContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal expectedElement = new ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		postParseCommands.add(new ASPMM.resource.aspmm.IAspmmCommand<ASPMM.resource.aspmm.IAspmmTextResource>() {
    			public boolean execute(ASPMM.resource.aspmm.IAspmmTextResource resource) {
    				ASPMM.resource.aspmm.IAspmmLocationMap locationMap = resource.getLocationMap();
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
    		postParseCommands.add(new ASPMM.resource.aspmm.IAspmmCommand<ASPMM.resource.aspmm.IAspmmTextResource>() {
    			public boolean execute(ASPMM.resource.aspmm.IAspmmTextResource resource) {
    				ASPMM.resource.aspmm.IAspmmLocationMap locationMap = resource.getLocationMap();
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
    	protected void setLocalizationEnd(java.util.Collection<ASPMM.resource.aspmm.IAspmmCommand<ASPMM.resource.aspmm.IAspmmTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new ASPMM.resource.aspmm.IAspmmCommand<ASPMM.resource.aspmm.IAspmmTextResource>() {
    			public boolean execute(ASPMM.resource.aspmm.IAspmmTextResource resource) {
    				ASPMM.resource.aspmm.IAspmmLocationMap locationMap = resource.getLocationMap();
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
    	
    	public ASPMM.resource.aspmm.IAspmmTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new AspmmParser(new org.antlr.runtime3_4_0.CommonTokenStream(new AspmmLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new AspmmParser(new org.antlr.runtime3_4_0.CommonTokenStream(new AspmmLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new ASPMM.resource.aspmm.util.AspmmRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public AspmmParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((AspmmLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((AspmmLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == ASPMM.Metamodel.class) {
    				return parse_ASPMM_Metamodel();
    			}
    			if (type.getInstanceClass() == ASPMM.Metanode.class) {
    				return parse_ASPMM_Metanode();
    			}
    			if (type.getInstanceClass() == ASPMM.Metaprop.class) {
    				return parse_ASPMM_Metaprop();
    			}
    			if (type.getInstanceClass() == ASPMM.Metaedge.class) {
    				return parse_ASPMM_Metaedge();
    			}
    		}
    		throw new ASPMM.resource.aspmm.mopp.AspmmUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(ASPMM.resource.aspmm.IAspmmOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public ASPMM.resource.aspmm.IAspmmParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<ASPMM.resource.aspmm.IAspmmCommand<ASPMM.resource.aspmm.IAspmmTextResource>>();
    		ASPMM.resource.aspmm.mopp.AspmmParseResult parseResult = new ASPMM.resource.aspmm.mopp.AspmmParseResult();
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
    	
    	public java.util.List<ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, ASPMM.resource.aspmm.IAspmmTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		ASPMM.resource.aspmm.IAspmmParseResult result = parse();
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
    			for (ASPMM.resource.aspmm.IAspmmCommand<ASPMM.resource.aspmm.IAspmmTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal>();
    		java.util.List<ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal> newFollowSet = new java.util.ArrayList<ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 38;
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
    				for (ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<ASPMM.resource.aspmm.util.AspmmPair<ASPMM.resource.aspmm.IAspmmExpectedElement, ASPMM.resource.aspmm.mopp.AspmmContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (ASPMM.resource.aspmm.util.AspmmPair<ASPMM.resource.aspmm.IAspmmExpectedElement, ASPMM.resource.aspmm.mopp.AspmmContainedFeature[]> newFollowerPair : newFollowers) {
    							ASPMM.resource.aspmm.IAspmmExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							ASPMM.resource.aspmm.grammar.AspmmContainmentTrace containmentTrace = new ASPMM.resource.aspmm.grammar.AspmmContainmentTrace(null, newFollowerPair.getRight());
    							ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal newFollowTerminal = new ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(ASPMM.resource.aspmm.mopp.AspmmExpectedTerminal expectedElement, int tokenIndex) {
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
    // Aspmm.g:508:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_ASPMM_Metamodel ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        ASPMM.Metamodel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Aspmm.g:509:2: ( (c0= parse_ASPMM_Metamodel ) EOF )
            // Aspmm.g:510:2: (c0= parse_ASPMM_Metamodel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Aspmm.g:515:2: (c0= parse_ASPMM_Metamodel )
            // Aspmm.g:516:3: c0= parse_ASPMM_Metamodel
            {
            pushFollow(FOLLOW_parse_ASPMM_Metamodel_in_start82);
            c0=parse_ASPMM_Metamodel();

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



    // $ANTLR start "parse_ASPMM_Metamodel"
    // Aspmm.g:524:1: parse_ASPMM_Metamodel returns [ASPMM.Metamodel element = null] : a0= 'metamodel' a1= '(' (a2= TEXT ) a3= ')' a4= '.' ( (a5_0= parse_ASPMM_Metanode ) )* ( (a6_0= parse_ASPMM_Metaprop ) )* ( (a7_0= parse_ASPMM_Metaedge ) )* ;
    public final ASPMM.Metamodel parse_ASPMM_Metamodel() throws RecognitionException {
        ASPMM.Metamodel element =  null;

        int parse_ASPMM_Metamodel_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        ASPMM.Metanode a5_0 =null;

        ASPMM.Metaprop a6_0 =null;

        ASPMM.Metaedge a7_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Aspmm.g:527:2: (a0= 'metamodel' a1= '(' (a2= TEXT ) a3= ')' a4= '.' ( (a5_0= parse_ASPMM_Metanode ) )* ( (a6_0= parse_ASPMM_Metaprop ) )* ( (a7_0= parse_ASPMM_Metaedge ) )* )
            // Aspmm.g:528:2: a0= 'metamodel' a1= '(' (a2= TEXT ) a3= ')' a4= '.' ( (a5_0= parse_ASPMM_Metanode ) )* ( (a6_0= parse_ASPMM_Metaprop ) )* ( (a7_0= parse_ASPMM_Metaedge ) )*
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_ASPMM_Metamodel115); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetamodel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_0_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[1]);
            	}

            a1=(Token)match(input,7,FOLLOW_7_in_parse_ASPMM_Metamodel129); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetamodel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_0_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[2]);
            	}

            // Aspmm.g:556:2: (a2= TEXT )
            // Aspmm.g:557:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPMM_Metamodel147); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPMM.resource.aspmm.mopp.AspmmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPMM.ASPMMFactory.eINSTANCE.createMetamodel();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASPMM.resource.aspmm.IAspmmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPMM.resource.aspmm.IAspmmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_0_0_0_2, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[3]);
            	}

            a3=(Token)match(input,8,FOLLOW_8_in_parse_ASPMM_Metamodel168); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetamodel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_0_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[4]);
            	}

            a4=(Token)match(input,10,FOLLOW_10_in_parse_ASPMM_Metamodel182); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetamodel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_0_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[6]);
            		addExpectedElement(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[7]);
            	}

            // Aspmm.g:622:2: ( (a5_0= parse_ASPMM_Metanode ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Aspmm.g:623:3: (a5_0= parse_ASPMM_Metanode )
            	    {
            	    // Aspmm.g:623:3: (a5_0= parse_ASPMM_Metanode )
            	    // Aspmm.g:624:4: a5_0= parse_ASPMM_Metanode
            	    {
            	    pushFollow(FOLLOW_parse_ASPMM_Metanode_in_parse_ASPMM_Metamodel205);
            	    a5_0=parse_ASPMM_Metanode();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new ASPMM.resource.aspmm.mopp.AspmmTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = ASPMM.ASPMMFactory.eINSTANCE.createMetamodel();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a5_0 != null) {
            	    					if (a5_0 != null) {
            	    						Object value = a5_0;
            	    						addObjectToList(element, ASPMM.ASPMMPackage.METAMODEL__METANODES, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_0_0_0_6, a5_0, true);
            	    					copyLocalizationInfos(a5_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[8]);
            		addExpectedElement(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[10]);
            	}

            // Aspmm.g:652:2: ( (a6_0= parse_ASPMM_Metaprop ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==17) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Aspmm.g:653:3: (a6_0= parse_ASPMM_Metaprop )
            	    {
            	    // Aspmm.g:653:3: (a6_0= parse_ASPMM_Metaprop )
            	    // Aspmm.g:654:4: a6_0= parse_ASPMM_Metaprop
            	    {
            	    pushFollow(FOLLOW_parse_ASPMM_Metaprop_in_parse_ASPMM_Metamodel240);
            	    a6_0=parse_ASPMM_Metaprop();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new ASPMM.resource.aspmm.mopp.AspmmTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = ASPMM.ASPMMFactory.eINSTANCE.createMetamodel();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a6_0 != null) {
            	    					if (a6_0 != null) {
            	    						Object value = a6_0;
            	    						addObjectToList(element, ASPMM.ASPMMPackage.METAMODEL__METAPROPS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_0_0_0_7, a6_0, true);
            	    					copyLocalizationInfos(a6_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[11]);
            		addExpectedElement(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[12]);
            	}

            // Aspmm.g:681:2: ( (a7_0= parse_ASPMM_Metaedge ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Aspmm.g:682:3: (a7_0= parse_ASPMM_Metaedge )
            	    {
            	    // Aspmm.g:682:3: (a7_0= parse_ASPMM_Metaedge )
            	    // Aspmm.g:683:4: a7_0= parse_ASPMM_Metaedge
            	    {
            	    pushFollow(FOLLOW_parse_ASPMM_Metaedge_in_parse_ASPMM_Metamodel275);
            	    a7_0=parse_ASPMM_Metaedge();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new ASPMM.resource.aspmm.mopp.AspmmTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = ASPMM.ASPMMFactory.eINSTANCE.createMetamodel();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a7_0 != null) {
            	    					if (a7_0 != null) {
            	    						Object value = a7_0;
            	    						addObjectToList(element, ASPMM.ASPMMPackage.METAMODEL__METAEDGES, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_0_0_0_8, a7_0, true);
            	    					copyLocalizationInfos(a7_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[13]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_ASPMM_Metamodel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPMM_Metamodel"



    // $ANTLR start "parse_ASPMM_Metanode"
    // Aspmm.g:711:1: parse_ASPMM_Metanode returns [ASPMM.Metanode element = null] : a0= 'metanode' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ')' a6= '.' ;
    public final ASPMM.Metanode parse_ASPMM_Metanode() throws RecognitionException {
        ASPMM.Metanode element =  null;

        int parse_ASPMM_Metanode_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Aspmm.g:714:2: (a0= 'metanode' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ')' a6= '.' )
            // Aspmm.g:715:2: a0= 'metanode' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ')' a6= '.'
            {
            a0=(Token)match(input,16,FOLLOW_16_in_parse_ASPMM_Metanode316); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetanode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[14]);
            	}

            a1=(Token)match(input,7,FOLLOW_7_in_parse_ASPMM_Metanode330); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetanode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_1_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[15]);
            	}

            // Aspmm.g:743:2: (a2= TEXT )
            // Aspmm.g:744:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPMM_Metanode348); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPMM.resource.aspmm.mopp.AspmmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPMM.ASPMMFactory.eINSTANCE.createMetanode();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASPMM.resource.aspmm.IAspmmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPMM.resource.aspmm.IAspmmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__METAMODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASPMM.Metamodel proxy = ASPMM.ASPMMFactory.eINSTANCE.createMetamodel();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASPMM.resource.aspmm.mopp.AspmmContextDependentURIFragmentFactory<ASPMM.Metanode, ASPMM.Metamodel>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMetanodeMetamodelReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__METAMODEL), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__METAMODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_1_0_0_2, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[16]);
            	}

            a3=(Token)match(input,9,FOLLOW_9_in_parse_ASPMM_Metanode369); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetanode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_1_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[17]);
            	}

            // Aspmm.g:797:2: (a4= TEXT )
            // Aspmm.g:798:3: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPMM_Metanode387); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPMM.resource.aspmm.mopp.AspmmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPMM.ASPMMFactory.eINSTANCE.createMetanode();
            				startIncompleteElement(element);
            			}
            			if (a4 != null) {
            				ASPMM.resource.aspmm.IAspmmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPMM.resource.aspmm.IAspmmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_1_0_0_4, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[18]);
            	}

            a5=(Token)match(input,8,FOLLOW_8_in_parse_ASPMM_Metanode408); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetanode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_1_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[19]);
            	}

            a6=(Token)match(input,10,FOLLOW_10_in_parse_ASPMM_Metanode422); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetanode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_1_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[20]);
            		addExpectedElement(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[21]);
            		addExpectedElement(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[22]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_ASPMM_Metanode_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPMM_Metanode"



    // $ANTLR start "parse_ASPMM_Metaprop"
    // Aspmm.g:865:1: parse_ASPMM_Metaprop returns [ASPMM.Metaprop element = null] : a0= 'metaprop' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= TEXT ) a7= ')' a8= '.' ;
    public final ASPMM.Metaprop parse_ASPMM_Metaprop() throws RecognitionException {
        ASPMM.Metaprop element =  null;

        int parse_ASPMM_Metaprop_StartIndex = input.index();

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
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Aspmm.g:868:2: (a0= 'metaprop' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= TEXT ) a7= ')' a8= '.' )
            // Aspmm.g:869:2: a0= 'metaprop' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= TEXT ) a7= ')' a8= '.'
            {
            a0=(Token)match(input,17,FOLLOW_17_in_parse_ASPMM_Metaprop451); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetaprop();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[23]);
            	}

            a1=(Token)match(input,7,FOLLOW_7_in_parse_ASPMM_Metaprop465); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetaprop();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[24]);
            	}

            // Aspmm.g:897:2: (a2= TEXT )
            // Aspmm.g:898:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPMM_Metaprop483); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPMM.resource.aspmm.mopp.AspmmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPMM.ASPMMFactory.eINSTANCE.createMetaprop();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASPMM.resource.aspmm.IAspmmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPMM.resource.aspmm.IAspmmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METAMODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASPMM.Metamodel proxy = ASPMM.ASPMMFactory.eINSTANCE.createMetamodel();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASPMM.resource.aspmm.mopp.AspmmContextDependentURIFragmentFactory<ASPMM.Metaprop, ASPMM.Metamodel>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMetapropMetamodelReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METAMODEL), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METAMODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_2, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[25]);
            	}

            a3=(Token)match(input,9,FOLLOW_9_in_parse_ASPMM_Metaprop504); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetaprop();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[26]);
            	}

            // Aspmm.g:951:2: (a4= TEXT )
            // Aspmm.g:952:3: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPMM_Metaprop522); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPMM.resource.aspmm.mopp.AspmmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPMM.ASPMMFactory.eINSTANCE.createMetaprop();
            				startIncompleteElement(element);
            			}
            			if (a4 != null) {
            				ASPMM.resource.aspmm.IAspmmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPMM.resource.aspmm.IAspmmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_4, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[27]);
            	}

            a5=(Token)match(input,9,FOLLOW_9_in_parse_ASPMM_Metaprop543); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetaprop();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[28]);
            	}

            // Aspmm.g:1001:2: (a6= TEXT )
            // Aspmm.g:1002:3: a6= TEXT
            {
            a6=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPMM_Metaprop561); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPMM.resource.aspmm.mopp.AspmmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPMM.ASPMMFactory.eINSTANCE.createMetaprop();
            				startIncompleteElement(element);
            			}
            			if (a6 != null) {
            				ASPMM.resource.aspmm.IAspmmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPMM.resource.aspmm.IAspmmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METANODE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASPMM.Metanode proxy = ASPMM.ASPMMFactory.eINSTANCE.createMetanode();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASPMM.resource.aspmm.mopp.AspmmContextDependentURIFragmentFactory<ASPMM.Metaprop, ASPMM.Metanode>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMetapropMetanodeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METANODE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METANODE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_6, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[29]);
            	}

            a7=(Token)match(input,8,FOLLOW_8_in_parse_ASPMM_Metaprop582); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetaprop();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[30]);
            	}

            a8=(Token)match(input,10,FOLLOW_10_in_parse_ASPMM_Metaprop596); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetaprop();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_2_0_0_8, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[31]);
            		addExpectedElement(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[32]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_ASPMM_Metaprop_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPMM_Metaprop"



    // $ANTLR start "parse_ASPMM_Metaedge"
    // Aspmm.g:1072:1: parse_ASPMM_Metaedge returns [ASPMM.Metaedge element = null] : a0= 'metaedge' a1= '(' (a2= TEXT ) a3= ',' ( (a4= 'association' |a5= 'generalization' |a6= 'composition' ) ) a9= ',' (a10= TEXT ) a11= ',' (a12= TEXT ) a13= ',' (a14= TEXT ) a15= ')' a16= '.' ;
    public final ASPMM.Metaedge parse_ASPMM_Metaedge() throws RecognitionException {
        ASPMM.Metaedge element =  null;

        int parse_ASPMM_Metaedge_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a16=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Aspmm.g:1075:2: (a0= 'metaedge' a1= '(' (a2= TEXT ) a3= ',' ( (a4= 'association' |a5= 'generalization' |a6= 'composition' ) ) a9= ',' (a10= TEXT ) a11= ',' (a12= TEXT ) a13= ',' (a14= TEXT ) a15= ')' a16= '.' )
            // Aspmm.g:1076:2: a0= 'metaedge' a1= '(' (a2= TEXT ) a3= ',' ( (a4= 'association' |a5= 'generalization' |a6= 'composition' ) ) a9= ',' (a10= TEXT ) a11= ',' (a12= TEXT ) a13= ',' (a14= TEXT ) a15= ')' a16= '.'
            {
            a0=(Token)match(input,14,FOLLOW_14_in_parse_ASPMM_Metaedge625); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetaedge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[33]);
            	}

            a1=(Token)match(input,7,FOLLOW_7_in_parse_ASPMM_Metaedge639); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetaedge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[34]);
            	}

            // Aspmm.g:1104:2: (a2= TEXT )
            // Aspmm.g:1105:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPMM_Metaedge657); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPMM.resource.aspmm.mopp.AspmmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPMM.ASPMMFactory.eINSTANCE.createMetaedge();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASPMM.resource.aspmm.IAspmmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPMM.resource.aspmm.IAspmmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__METAMODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASPMM.Metamodel proxy = ASPMM.ASPMMFactory.eINSTANCE.createMetamodel();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASPMM.resource.aspmm.mopp.AspmmContextDependentURIFragmentFactory<ASPMM.Metaedge, ASPMM.Metamodel>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMetaedgeMetamodelReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__METAMODEL), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__METAMODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_2, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[35]);
            	}

            a3=(Token)match(input,9,FOLLOW_9_in_parse_ASPMM_Metaedge678); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetaedge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[36]);
            	}

            // Aspmm.g:1158:2: ( (a4= 'association' |a5= 'generalization' |a6= 'composition' ) )
            // Aspmm.g:1159:3: (a4= 'association' |a5= 'generalization' |a6= 'composition' )
            {
            // Aspmm.g:1159:3: (a4= 'association' |a5= 'generalization' |a6= 'composition' )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt4=1;
                }
                break;
            case 13:
                {
                alt4=2;
                }
                break;
            case 12:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // Aspmm.g:1160:4: a4= 'association'
                    {
                    a4=(Token)match(input,11,FOLLOW_11_in_parse_ASPMM_Metaedge701); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASPMM.ASPMMFactory.eINSTANCE.createMetaedge();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_4, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    				// set value of enumeration attribute
                    				Object value = ASPMM.ASPMMPackage.eINSTANCE.getMetaedgeType().getEEnumLiteral(ASPMM.MetaedgeType.ASSOCIATION_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Aspmm.g:1173:8: a5= 'generalization'
                    {
                    a5=(Token)match(input,13,FOLLOW_13_in_parse_ASPMM_Metaedge716); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASPMM.ASPMMFactory.eINSTANCE.createMetaedge();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_4, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    				// set value of enumeration attribute
                    				Object value = ASPMM.ASPMMPackage.eINSTANCE.getMetaedgeType().getEEnumLiteral(ASPMM.MetaedgeType.GENERALIZATION_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Aspmm.g:1186:8: a6= 'composition'
                    {
                    a6=(Token)match(input,12,FOLLOW_12_in_parse_ASPMM_Metaedge731); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASPMM.ASPMMFactory.eINSTANCE.createMetaedge();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_4, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    				// set value of enumeration attribute
                    				Object value = ASPMM.ASPMMPackage.eINSTANCE.getMetaedgeType().getEEnumLiteral(ASPMM.MetaedgeType.COMPOSITION_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[37]);
            	}

            a9=(Token)match(input,9,FOLLOW_9_in_parse_ASPMM_Metaedge752); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetaedge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[38]);
            	}

            // Aspmm.g:1220:2: (a10= TEXT )
            // Aspmm.g:1221:3: a10= TEXT
            {
            a10=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPMM_Metaedge770); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPMM.resource.aspmm.mopp.AspmmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPMM.ASPMMFactory.eINSTANCE.createMetaedge();
            				startIncompleteElement(element);
            			}
            			if (a10 != null) {
            				ASPMM.resource.aspmm.IAspmmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPMM.resource.aspmm.IAspmmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_6, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[39]);
            	}

            a11=(Token)match(input,9,FOLLOW_9_in_parse_ASPMM_Metaedge791); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetaedge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[40]);
            	}

            // Aspmm.g:1270:2: (a12= TEXT )
            // Aspmm.g:1271:3: a12= TEXT
            {
            a12=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPMM_Metaedge809); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPMM.resource.aspmm.mopp.AspmmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPMM.ASPMMFactory.eINSTANCE.createMetaedge();
            				startIncompleteElement(element);
            			}
            			if (a12 != null) {
            				ASPMM.resource.aspmm.IAspmmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPMM.resource.aspmm.IAspmmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__SOURCE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASPMM.Metanode proxy = ASPMM.ASPMMFactory.eINSTANCE.createMetanode();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASPMM.resource.aspmm.mopp.AspmmContextDependentURIFragmentFactory<ASPMM.Metaedge, ASPMM.Metanode>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMetaedgeSourceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__SOURCE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__SOURCE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_8, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[41]);
            	}

            a13=(Token)match(input,9,FOLLOW_9_in_parse_ASPMM_Metaedge830); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetaedge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_9, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[42]);
            	}

            // Aspmm.g:1324:2: (a14= TEXT )
            // Aspmm.g:1325:3: a14= TEXT
            {
            a14=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPMM_Metaedge848); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPMM.resource.aspmm.mopp.AspmmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPMM.ASPMMFactory.eINSTANCE.createMetaedge();
            				startIncompleteElement(element);
            			}
            			if (a14 != null) {
            				ASPMM.resource.aspmm.IAspmmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPMM.resource.aspmm.IAspmmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__TARGET), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a14).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASPMM.Metanode proxy = ASPMM.ASPMMFactory.eINSTANCE.createMetanode();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASPMM.resource.aspmm.mopp.AspmmContextDependentURIFragmentFactory<ASPMM.Metaedge, ASPMM.Metanode>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMetaedgeTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__TARGET), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__TARGET), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_10, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[43]);
            	}

            a15=(Token)match(input,8,FOLLOW_8_in_parse_ASPMM_Metaedge869); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetaedge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_11, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[44]);
            	}

            a16=(Token)match(input,10,FOLLOW_10_in_parse_ASPMM_Metaedge883); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPMM.ASPMMFactory.eINSTANCE.createMetaedge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPMM.resource.aspmm.grammar.AspmmGrammarInformationProvider.ASPMM_3_0_0_12, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPMM.ASPMMPackage.eINSTANCE.getMetamodel(), ASPMM.resource.aspmm.mopp.AspmmExpectationConstants.EXPECTATIONS[45]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_ASPMM_Metaedge_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPMM_Metaedge"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_ASPMM_Metamodel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_ASPMM_Metamodel115 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_parse_ASPMM_Metamodel129 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPMM_Metamodel147 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPMM_Metamodel168 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPMM_Metamodel182 = new BitSet(new long[]{0x0000000000034002L});
    public static final BitSet FOLLOW_parse_ASPMM_Metanode_in_parse_ASPMM_Metamodel205 = new BitSet(new long[]{0x0000000000034002L});
    public static final BitSet FOLLOW_parse_ASPMM_Metaprop_in_parse_ASPMM_Metamodel240 = new BitSet(new long[]{0x0000000000024002L});
    public static final BitSet FOLLOW_parse_ASPMM_Metaedge_in_parse_ASPMM_Metamodel275 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_16_in_parse_ASPMM_Metanode316 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_parse_ASPMM_Metanode330 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPMM_Metanode348 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPMM_Metanode369 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPMM_Metanode387 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPMM_Metanode408 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPMM_Metanode422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_ASPMM_Metaprop451 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_parse_ASPMM_Metaprop465 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPMM_Metaprop483 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPMM_Metaprop504 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPMM_Metaprop522 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPMM_Metaprop543 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPMM_Metaprop561 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPMM_Metaprop582 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPMM_Metaprop596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_ASPMM_Metaedge625 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_parse_ASPMM_Metaedge639 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPMM_Metaedge657 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPMM_Metaedge678 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_11_in_parse_ASPMM_Metaedge701 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_13_in_parse_ASPMM_Metaedge716 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_12_in_parse_ASPMM_Metaedge731 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPMM_Metaedge752 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPMM_Metaedge770 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPMM_Metaedge791 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPMM_Metaedge809 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPMM_Metaedge830 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPMM_Metaedge848 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPMM_Metaedge869 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPMM_Metaedge883 = new BitSet(new long[]{0x0000000000000002L});

}