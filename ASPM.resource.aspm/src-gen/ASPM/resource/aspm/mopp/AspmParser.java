// $ANTLR 3.4

	package ASPM.resource.aspm.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AspmParser extends AspmANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LINEBREAK", "QUOTED_34_34_92", "TEXT", "WHITESPACE", "'('", "')'", "','", "'.'", "'edge'", "'model'", "'node'", "'prop'"
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
    public static final int LINEBREAK=4;
    public static final int QUOTED_34_34_92=5;
    public static final int TEXT=6;
    public static final int WHITESPACE=7;

    // delegates
    public AspmANTLRParserBase[] getDelegates() {
        return new AspmANTLRParserBase[] {};
    }

    // delegators


    public AspmParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public AspmParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(8 + 1);
         

    }

    public String[] getTokenNames() { return AspmParser.tokenNames; }
    public String getGrammarFileName() { return "Aspm.g"; }


    	private ASPM.resource.aspm.IAspmTokenResolverFactory tokenResolverFactory = new ASPM.resource.aspm.mopp.AspmTokenResolverFactory();
    	
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
    	private java.util.List<ASPM.resource.aspm.mopp.AspmExpectedTerminal> expectedElements = new java.util.ArrayList<ASPM.resource.aspm.mopp.AspmExpectedTerminal>();
    	
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
    		postParseCommands.add(new ASPM.resource.aspm.IAspmCommand<ASPM.resource.aspm.IAspmTextResource>() {
    			public boolean execute(ASPM.resource.aspm.IAspmTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new ASPM.resource.aspm.IAspmProblem() {
    					public ASPM.resource.aspm.AspmEProblemSeverity getSeverity() {
    						return ASPM.resource.aspm.AspmEProblemSeverity.ERROR;
    					}
    					public ASPM.resource.aspm.AspmEProblemType getType() {
    						return ASPM.resource.aspm.AspmEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<ASPM.resource.aspm.IAspmQuickFix> getQuickFixes() {
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
    		ASPM.resource.aspm.IAspmExpectedElement terminal = ASPM.resource.aspm.grammar.AspmFollowSetProvider.TERMINALS[terminalID];
    		ASPM.resource.aspm.mopp.AspmContainedFeature[] containmentFeatures = new ASPM.resource.aspm.mopp.AspmContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = ASPM.resource.aspm.grammar.AspmFollowSetProvider.LINKS[ids[i]];
    		}
    		ASPM.resource.aspm.grammar.AspmContainmentTrace containmentTrace = new ASPM.resource.aspm.grammar.AspmContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		ASPM.resource.aspm.mopp.AspmExpectedTerminal expectedElement = new ASPM.resource.aspm.mopp.AspmExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		postParseCommands.add(new ASPM.resource.aspm.IAspmCommand<ASPM.resource.aspm.IAspmTextResource>() {
    			public boolean execute(ASPM.resource.aspm.IAspmTextResource resource) {
    				ASPM.resource.aspm.IAspmLocationMap locationMap = resource.getLocationMap();
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
    		postParseCommands.add(new ASPM.resource.aspm.IAspmCommand<ASPM.resource.aspm.IAspmTextResource>() {
    			public boolean execute(ASPM.resource.aspm.IAspmTextResource resource) {
    				ASPM.resource.aspm.IAspmLocationMap locationMap = resource.getLocationMap();
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
    	protected void setLocalizationEnd(java.util.Collection<ASPM.resource.aspm.IAspmCommand<ASPM.resource.aspm.IAspmTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new ASPM.resource.aspm.IAspmCommand<ASPM.resource.aspm.IAspmTextResource>() {
    			public boolean execute(ASPM.resource.aspm.IAspmTextResource resource) {
    				ASPM.resource.aspm.IAspmLocationMap locationMap = resource.getLocationMap();
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
    	
    	public ASPM.resource.aspm.IAspmTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new AspmParser(new org.antlr.runtime3_4_0.CommonTokenStream(new AspmLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new AspmParser(new org.antlr.runtime3_4_0.CommonTokenStream(new AspmLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new ASPM.resource.aspm.util.AspmRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public AspmParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((AspmLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((AspmLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == ASPM.Model.class) {
    				return parse_ASPM_Model();
    			}
    			if (type.getInstanceClass() == ASPM.Node.class) {
    				return parse_ASPM_Node();
    			}
    			if (type.getInstanceClass() == ASPM.Prop.class) {
    				return parse_ASPM_Prop();
    			}
    			if (type.getInstanceClass() == ASPM.Edge.class) {
    				return parse_ASPM_Edge();
    			}
    		}
    		throw new ASPM.resource.aspm.mopp.AspmUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(ASPM.resource.aspm.IAspmOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public ASPM.resource.aspm.IAspmParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<ASPM.resource.aspm.IAspmCommand<ASPM.resource.aspm.IAspmTextResource>>();
    		ASPM.resource.aspm.mopp.AspmParseResult parseResult = new ASPM.resource.aspm.mopp.AspmParseResult();
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
    	
    	public java.util.List<ASPM.resource.aspm.mopp.AspmExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, ASPM.resource.aspm.IAspmTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		ASPM.resource.aspm.IAspmParseResult result = parse();
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
    			for (ASPM.resource.aspm.IAspmCommand<ASPM.resource.aspm.IAspmTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<ASPM.resource.aspm.mopp.AspmExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<ASPM.resource.aspm.mopp.AspmExpectedTerminal>();
    		java.util.List<ASPM.resource.aspm.mopp.AspmExpectedTerminal> newFollowSet = new java.util.ArrayList<ASPM.resource.aspm.mopp.AspmExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			ASPM.resource.aspm.mopp.AspmExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 58;
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
    				for (ASPM.resource.aspm.mopp.AspmExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (ASPM.resource.aspm.mopp.AspmExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<ASPM.resource.aspm.util.AspmPair<ASPM.resource.aspm.IAspmExpectedElement, ASPM.resource.aspm.mopp.AspmContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (ASPM.resource.aspm.util.AspmPair<ASPM.resource.aspm.IAspmExpectedElement, ASPM.resource.aspm.mopp.AspmContainedFeature[]> newFollowerPair : newFollowers) {
    							ASPM.resource.aspm.IAspmExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							ASPM.resource.aspm.grammar.AspmContainmentTrace containmentTrace = new ASPM.resource.aspm.grammar.AspmContainmentTrace(null, newFollowerPair.getRight());
    							ASPM.resource.aspm.mopp.AspmExpectedTerminal newFollowTerminal = new ASPM.resource.aspm.mopp.AspmExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (ASPM.resource.aspm.mopp.AspmExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(ASPM.resource.aspm.mopp.AspmExpectedTerminal expectedElement, int tokenIndex) {
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
    // Aspm.g:508:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_ASPM_Model ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        ASPM.Model c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Aspm.g:509:2: ( (c0= parse_ASPM_Model ) EOF )
            // Aspm.g:510:2: (c0= parse_ASPM_Model ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Aspm.g:515:2: (c0= parse_ASPM_Model )
            // Aspm.g:516:3: c0= parse_ASPM_Model
            {
            pushFollow(FOLLOW_parse_ASPM_Model_in_start82);
            c0=parse_ASPM_Model();

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



    // $ANTLR start "parse_ASPM_Model"
    // Aspm.g:524:1: parse_ASPM_Model returns [ASPM.Model element = null] : a0= 'model' a1= '(' (a2= QUOTED_34_34_92 ) a3= ',' (a4= TEXT ) a5= ')' a6= '.' ( (a7_0= parse_ASPM_Node ) )* ( (a8_0= parse_ASPM_Prop ) )* ( (a9_0= parse_ASPM_Edge ) )* ;
    public final ASPM.Model parse_ASPM_Model() throws RecognitionException {
        ASPM.Model element =  null;

        int parse_ASPM_Model_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        ASPM.Node a7_0 =null;

        ASPM.Prop a8_0 =null;

        ASPM.Edge a9_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Aspm.g:527:2: (a0= 'model' a1= '(' (a2= QUOTED_34_34_92 ) a3= ',' (a4= TEXT ) a5= ')' a6= '.' ( (a7_0= parse_ASPM_Node ) )* ( (a8_0= parse_ASPM_Prop ) )* ( (a9_0= parse_ASPM_Edge ) )* )
            // Aspm.g:528:2: a0= 'model' a1= '(' (a2= QUOTED_34_34_92 ) a3= ',' (a4= TEXT ) a5= ')' a6= '.' ( (a7_0= parse_ASPM_Node ) )* ( (a8_0= parse_ASPM_Prop ) )* ( (a9_0= parse_ASPM_Edge ) )*
            {
            a0=(Token)match(input,13,FOLLOW_13_in_parse_ASPM_Model115); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[1]);
            	}

            a1=(Token)match(input,8,FOLLOW_8_in_parse_ASPM_Model129); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[2]);
            	}

            // Aspm.g:556:2: (a2= QUOTED_34_34_92 )
            // Aspm.g:557:3: a2= QUOTED_34_34_92
            {
            a2=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Model147); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createModel();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__ID), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__ID), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_2, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[3]);
            	}

            a3=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Model168); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[4]);
            	}

            // Aspm.g:606:2: (a4= TEXT )
            // Aspm.g:607:3: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPM_Model186); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createModel();
            				startIncompleteElement(element);
            			}
            			if (a4 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_4, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[5]);
            	}

            a5=(Token)match(input,9,FOLLOW_9_in_parse_ASPM_Model207); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[6]);
            	}

            a6=(Token)match(input,11,FOLLOW_11_in_parse_ASPM_Model221); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[7]);
            		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[8]);
            		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[9]);
            	}

            // Aspm.g:672:2: ( (a7_0= parse_ASPM_Node ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Aspm.g:673:3: (a7_0= parse_ASPM_Node )
            	    {
            	    // Aspm.g:673:3: (a7_0= parse_ASPM_Node )
            	    // Aspm.g:674:4: a7_0= parse_ASPM_Node
            	    {
            	    pushFollow(FOLLOW_parse_ASPM_Node_in_parse_ASPM_Model244);
            	    a7_0=parse_ASPM_Node();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = ASPM.ASPMFactory.eINSTANCE.createModel();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a7_0 != null) {
            	    					if (a7_0 != null) {
            	    						Object value = a7_0;
            	    						addObjectToList(element, ASPM.ASPMPackage.MODEL__NODES, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_8, a7_0, true);
            	    					copyLocalizationInfos(a7_0, element);
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
            		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[10]);
            		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[11]);
            		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[12]);
            	}

            // Aspm.g:702:2: ( (a8_0= parse_ASPM_Prop ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Aspm.g:703:3: (a8_0= parse_ASPM_Prop )
            	    {
            	    // Aspm.g:703:3: (a8_0= parse_ASPM_Prop )
            	    // Aspm.g:704:4: a8_0= parse_ASPM_Prop
            	    {
            	    pushFollow(FOLLOW_parse_ASPM_Prop_in_parse_ASPM_Model279);
            	    a8_0=parse_ASPM_Prop();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = ASPM.ASPMFactory.eINSTANCE.createModel();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a8_0 != null) {
            	    					if (a8_0 != null) {
            	    						Object value = a8_0;
            	    						addObjectToList(element, ASPM.ASPMPackage.MODEL__PROPS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_9, a8_0, true);
            	    					copyLocalizationInfos(a8_0, element);
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
            		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[13]);
            		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[14]);
            	}

            // Aspm.g:731:2: ( (a9_0= parse_ASPM_Edge ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Aspm.g:732:3: (a9_0= parse_ASPM_Edge )
            	    {
            	    // Aspm.g:732:3: (a9_0= parse_ASPM_Edge )
            	    // Aspm.g:733:4: a9_0= parse_ASPM_Edge
            	    {
            	    pushFollow(FOLLOW_parse_ASPM_Edge_in_parse_ASPM_Model314);
            	    a9_0=parse_ASPM_Edge();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = ASPM.ASPMFactory.eINSTANCE.createModel();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a9_0 != null) {
            	    					if (a9_0 != null) {
            	    						Object value = a9_0;
            	    						addObjectToList(element, ASPM.ASPMPackage.MODEL__EDGES, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_10, a9_0, true);
            	    					copyLocalizationInfos(a9_0, element);
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
            		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[15]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_ASPM_Model_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPM_Model"



    // $ANTLR start "parse_ASPM_Node"
    // Aspm.g:761:1: parse_ASPM_Node returns [ASPM.Node element = null] : a0= 'node' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ')' a10= '.' ;
    public final ASPM.Node parse_ASPM_Node() throws RecognitionException {
        ASPM.Node element =  null;

        int parse_ASPM_Node_StartIndex = input.index();

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
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Aspm.g:764:2: (a0= 'node' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ')' a10= '.' )
            // Aspm.g:765:2: a0= 'node' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ')' a10= '.'
            {
            a0=(Token)match(input,14,FOLLOW_14_in_parse_ASPM_Node355); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[16]);
            	}

            a1=(Token)match(input,8,FOLLOW_8_in_parse_ASPM_Node369); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[17]);
            	}

            // Aspm.g:793:2: (a2= TEXT )
            // Aspm.g:794:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPM_Node387); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createNode();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__MODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASPM.Model proxy = ASPM.ASPMFactory.eINSTANCE.createModel();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASPM.resource.aspm.mopp.AspmContextDependentURIFragmentFactory<ASPM.Node, ASPM.Model>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getNodeModelReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__MODEL), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__MODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_2, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[18]);
            	}

            a3=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Node408); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[19]);
            	}

            // Aspm.g:847:2: (a4= TEXT )
            // Aspm.g:848:3: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPM_Node426); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createNode();
            				startIncompleteElement(element);
            			}
            			if (a4 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__ID), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__ID), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_4, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[20]);
            	}

            a5=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Node447); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[21]);
            	}

            // Aspm.g:897:2: (a6= QUOTED_34_34_92 )
            // Aspm.g:898:3: a6= QUOTED_34_34_92
            {
            a6=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Node465); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createNode();
            				startIncompleteElement(element);
            			}
            			if (a6 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__IDTRACE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__IDTRACE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_6, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[22]);
            	}

            a7=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Node486); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[23]);
            	}

            // Aspm.g:947:2: (a8= TEXT )
            // Aspm.g:948:3: a8= TEXT
            {
            a8=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPM_Node504); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createNode();
            				startIncompleteElement(element);
            			}
            			if (a8 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_8, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[24]);
            	}

            a9=(Token)match(input,9,FOLLOW_9_in_parse_ASPM_Node525); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_9, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[25]);
            	}

            a10=(Token)match(input,11,FOLLOW_11_in_parse_ASPM_Node539); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_10, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[27]);
            		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[28]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_ASPM_Node_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPM_Node"



    // $ANTLR start "parse_ASPM_Prop"
    // Aspm.g:1015:1: parse_ASPM_Prop returns [ASPM.Prop element = null] : a0= 'prop' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= QUOTED_34_34_92 ) a11= ',' (a12= TEXT ) a13= ',' (a14= QUOTED_34_34_92 ) a15= ')' a16= '.' ;
    public final ASPM.Prop parse_ASPM_Prop() throws RecognitionException {
        ASPM.Prop element =  null;

        int parse_ASPM_Prop_StartIndex = input.index();

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
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Aspm.g:1018:2: (a0= 'prop' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= QUOTED_34_34_92 ) a11= ',' (a12= TEXT ) a13= ',' (a14= QUOTED_34_34_92 ) a15= ')' a16= '.' )
            // Aspm.g:1019:2: a0= 'prop' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= QUOTED_34_34_92 ) a11= ',' (a12= TEXT ) a13= ',' (a14= QUOTED_34_34_92 ) a15= ')' a16= '.'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_ASPM_Prop568); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[29]);
            	}

            a1=(Token)match(input,8,FOLLOW_8_in_parse_ASPM_Prop582); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[30]);
            	}

            // Aspm.g:1047:2: (a2= TEXT )
            // Aspm.g:1048:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPM_Prop600); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createProp();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__MODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASPM.Model proxy = ASPM.ASPMFactory.eINSTANCE.createModel();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASPM.resource.aspm.mopp.AspmContextDependentURIFragmentFactory<ASPM.Prop, ASPM.Model>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropModelReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__MODEL), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__MODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_2, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[31]);
            	}

            a3=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Prop621); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[32]);
            	}

            // Aspm.g:1101:2: (a4= TEXT )
            // Aspm.g:1102:3: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPM_Prop639); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createProp();
            				startIncompleteElement(element);
            			}
            			if (a4 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__ID), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__ID), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_4, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[33]);
            	}

            a5=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Prop660); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[34]);
            	}

            // Aspm.g:1151:2: (a6= QUOTED_34_34_92 )
            // Aspm.g:1152:3: a6= QUOTED_34_34_92
            {
            a6=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Prop678); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createProp();
            				startIncompleteElement(element);
            			}
            			if (a6 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__IDTRACE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__IDTRACE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_6, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[35]);
            	}

            a7=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Prop699); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[36]);
            	}

            // Aspm.g:1201:2: (a8= TEXT )
            // Aspm.g:1202:3: a8= TEXT
            {
            a8=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPM_Prop717); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createProp();
            				startIncompleteElement(element);
            			}
            			if (a8 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__OWNER), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASPM.Node proxy = ASPM.ASPMFactory.eINSTANCE.createNode();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASPM.resource.aspm.mopp.AspmContextDependentURIFragmentFactory<ASPM.Prop, ASPM.Node>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropOwnerReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__OWNER), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__OWNER), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_8, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[37]);
            	}

            a9=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Prop738); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_9, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[38]);
            	}

            // Aspm.g:1255:2: (a10= QUOTED_34_34_92 )
            // Aspm.g:1256:3: a10= QUOTED_34_34_92
            {
            a10=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Prop756); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createProp();
            				startIncompleteElement(element);
            			}
            			if (a10 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__OWNER_TRACE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__OWNER_TRACE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_10, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[39]);
            	}

            a11=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Prop777); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_11, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[40]);
            	}

            // Aspm.g:1305:2: (a12= TEXT )
            // Aspm.g:1306:3: a12= TEXT
            {
            a12=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPM_Prop795); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createProp();
            				startIncompleteElement(element);
            			}
            			if (a12 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_12, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[41]);
            	}

            a13=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Prop816); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_13, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[42]);
            	}

            // Aspm.g:1355:2: (a14= QUOTED_34_34_92 )
            // Aspm.g:1356:3: a14= QUOTED_34_34_92
            {
            a14=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Prop834); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createProp();
            				startIncompleteElement(element);
            			}
            			if (a14 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__VALUE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a14).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__VALUE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_14, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[43]);
            	}

            a15=(Token)match(input,9,FOLLOW_9_in_parse_ASPM_Prop855); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_15, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[44]);
            	}

            a16=(Token)match(input,11,FOLLOW_11_in_parse_ASPM_Prop869); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_16, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[45]);
            		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[46]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_ASPM_Prop_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPM_Prop"



    // $ANTLR start "parse_ASPM_Edge"
    // Aspm.g:1422:1: parse_ASPM_Edge returns [ASPM.Edge element = null] : a0= 'edge' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= TEXT ) a11= ',' (a12= QUOTED_34_34_92 ) a13= ',' (a14= TEXT ) a15= ',' (a16= QUOTED_34_34_92 ) a17= ')' a18= '.' ;
    public final ASPM.Edge parse_ASPM_Edge() throws RecognitionException {
        ASPM.Edge element =  null;

        int parse_ASPM_Edge_StartIndex = input.index();

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
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Aspm.g:1425:2: (a0= 'edge' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= TEXT ) a11= ',' (a12= QUOTED_34_34_92 ) a13= ',' (a14= TEXT ) a15= ',' (a16= QUOTED_34_34_92 ) a17= ')' a18= '.' )
            // Aspm.g:1426:2: a0= 'edge' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ',' (a6= QUOTED_34_34_92 ) a7= ',' (a8= TEXT ) a9= ',' (a10= TEXT ) a11= ',' (a12= QUOTED_34_34_92 ) a13= ',' (a14= TEXT ) a15= ',' (a16= QUOTED_34_34_92 ) a17= ')' a18= '.'
            {
            a0=(Token)match(input,12,FOLLOW_12_in_parse_ASPM_Edge898); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[47]);
            	}

            a1=(Token)match(input,8,FOLLOW_8_in_parse_ASPM_Edge912); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[48]);
            	}

            // Aspm.g:1454:2: (a2= TEXT )
            // Aspm.g:1455:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPM_Edge930); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__MODEL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASPM.Model proxy = ASPM.ASPMFactory.eINSTANCE.createModel();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASPM.resource.aspm.mopp.AspmContextDependentURIFragmentFactory<ASPM.Edge, ASPM.Model>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEdgeModelReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__MODEL), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__MODEL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_2, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[49]);
            	}

            a3=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Edge951); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[50]);
            	}

            // Aspm.g:1508:2: (a4= TEXT )
            // Aspm.g:1509:3: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPM_Edge969); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            				startIncompleteElement(element);
            			}
            			if (a4 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__ID), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__ID), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_4, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[51]);
            	}

            a5=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Edge990); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[52]);
            	}

            // Aspm.g:1558:2: (a6= QUOTED_34_34_92 )
            // Aspm.g:1559:3: a6= QUOTED_34_34_92
            {
            a6=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Edge1008); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            				startIncompleteElement(element);
            			}
            			if (a6 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__IDTRACE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__IDTRACE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_6, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[53]);
            	}

            a7=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Edge1029); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[54]);
            	}

            // Aspm.g:1608:2: (a8= TEXT )
            // Aspm.g:1609:3: a8= TEXT
            {
            a8=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPM_Edge1047); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            				startIncompleteElement(element);
            			}
            			if (a8 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_8, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[55]);
            	}

            a9=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Edge1068); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_9, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[56]);
            	}

            // Aspm.g:1658:2: (a10= TEXT )
            // Aspm.g:1659:3: a10= TEXT
            {
            a10=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPM_Edge1086); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            				startIncompleteElement(element);
            			}
            			if (a10 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__SOURCE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASPM.Node proxy = ASPM.ASPMFactory.eINSTANCE.createNode();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASPM.resource.aspm.mopp.AspmContextDependentURIFragmentFactory<ASPM.Edge, ASPM.Node>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEdgeSourceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__SOURCE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__SOURCE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_10, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[57]);
            	}

            a11=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Edge1107); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_11, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[58]);
            	}

            // Aspm.g:1712:2: (a12= QUOTED_34_34_92 )
            // Aspm.g:1713:3: a12= QUOTED_34_34_92
            {
            a12=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Edge1125); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            				startIncompleteElement(element);
            			}
            			if (a12 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__SOURCE_TRACE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__SOURCE_TRACE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_12, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[59]);
            	}

            a13=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Edge1146); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_13, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[60]);
            	}

            // Aspm.g:1762:2: (a14= TEXT )
            // Aspm.g:1763:3: a14= TEXT
            {
            a14=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASPM_Edge1164); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            				startIncompleteElement(element);
            			}
            			if (a14 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__TARGET), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a14).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASPM.Node proxy = ASPM.ASPMFactory.eINSTANCE.createNode();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASPM.resource.aspm.mopp.AspmContextDependentURIFragmentFactory<ASPM.Edge, ASPM.Node>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEdgeTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__TARGET), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__TARGET), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_14, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[61]);
            	}

            a15=(Token)match(input,10,FOLLOW_10_in_parse_ASPM_Edge1185); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_15, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[62]);
            	}

            // Aspm.g:1816:2: (a16= QUOTED_34_34_92 )
            // Aspm.g:1817:3: a16= QUOTED_34_34_92
            {
            a16=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Edge1203); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASPM.resource.aspm.mopp.AspmTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            				startIncompleteElement(element);
            			}
            			if (a16 != null) {
            				ASPM.resource.aspm.IAspmTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
            				tokenResolver.setOptions(getOptions());
            				ASPM.resource.aspm.IAspmTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a16.getText(), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__TARGET_TRACE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a16).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__TARGET_TRACE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_16, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a16, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[63]);
            	}

            a17=(Token)match(input,9,FOLLOW_9_in_parse_ASPM_Edge1224); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_17, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[64]);
            	}

            a18=(Token)match(input,11,FOLLOW_11_in_parse_ASPM_Edge1238); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_18, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[65]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_ASPM_Edge_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASPM_Edge"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_ASPM_Model_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parse_ASPM_Model115 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPM_Model129 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Model147 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Model168 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPM_Model186 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPM_Model207 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPM_Model221 = new BitSet(new long[]{0x000000000000D002L});
    public static final BitSet FOLLOW_parse_ASPM_Node_in_parse_ASPM_Model244 = new BitSet(new long[]{0x000000000000D002L});
    public static final BitSet FOLLOW_parse_ASPM_Prop_in_parse_ASPM_Model279 = new BitSet(new long[]{0x0000000000009002L});
    public static final BitSet FOLLOW_parse_ASPM_Edge_in_parse_ASPM_Model314 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_14_in_parse_ASPM_Node355 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPM_Node369 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPM_Node387 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Node408 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPM_Node426 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Node447 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Node465 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Node486 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPM_Node504 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPM_Node525 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPM_Node539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_ASPM_Prop568 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPM_Prop582 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPM_Prop600 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Prop621 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPM_Prop639 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Prop660 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Prop678 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Prop699 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPM_Prop717 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Prop738 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Prop756 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Prop777 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPM_Prop795 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Prop816 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Prop834 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPM_Prop855 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPM_Prop869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_parse_ASPM_Edge898 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_ASPM_Edge912 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPM_Edge930 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Edge951 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPM_Edge969 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Edge990 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Edge1008 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Edge1029 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPM_Edge1047 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Edge1068 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPM_Edge1086 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Edge1107 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Edge1125 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Edge1146 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASPM_Edge1164 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASPM_Edge1185 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_ASPM_Edge1203 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_ASPM_Edge1224 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASPM_Edge1238 = new BitSet(new long[]{0x0000000000000002L});

}