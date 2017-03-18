// $ANTLR 3.4

	package ASP.resource.asp.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AspParser extends AspANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "ELEMENT", "LINEBREAK", "QUOTED_40_41", "TEXT", "WHITESPACE", "'!='", "').'", "','", "'.'", "':-'", "'=='", "'edge('", "'edgex('", "'metaedge('", "'metanode('", "'metaprop('", "'node('", "'nodex('", "'not'", "'prop('", "'propx('", "'relation_edge'", "'relation_node'", "'relation_prop'"
    };

    public static final int EOF=-1;
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
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int COMMENT=4;
    public static final int ELEMENT=5;
    public static final int LINEBREAK=6;
    public static final int QUOTED_40_41=7;
    public static final int TEXT=8;
    public static final int WHITESPACE=9;

    // delegates
    public AspANTLRParserBase[] getDelegates() {
        return new AspANTLRParserBase[] {};
    }

    // delegators


    public AspParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public AspParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(47 + 1);
         

    }

    public String[] getTokenNames() { return AspParser.tokenNames; }
    public String getGrammarFileName() { return "Asp.g"; }


    	private ASP.resource.asp.IAspTokenResolverFactory tokenResolverFactory = new ASP.resource.asp.mopp.AspTokenResolverFactory();
    	
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
    	private java.util.List<ASP.resource.asp.mopp.AspExpectedTerminal> expectedElements = new java.util.ArrayList<ASP.resource.asp.mopp.AspExpectedTerminal>();
    	
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
    		postParseCommands.add(new ASP.resource.asp.IAspCommand<ASP.resource.asp.IAspTextResource>() {
    			public boolean execute(ASP.resource.asp.IAspTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new ASP.resource.asp.IAspProblem() {
    					public ASP.resource.asp.AspEProblemSeverity getSeverity() {
    						return ASP.resource.asp.AspEProblemSeverity.ERROR;
    					}
    					public ASP.resource.asp.AspEProblemType getType() {
    						return ASP.resource.asp.AspEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<ASP.resource.asp.IAspQuickFix> getQuickFixes() {
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
    		ASP.resource.asp.IAspExpectedElement terminal = ASP.resource.asp.grammar.AspFollowSetProvider.TERMINALS[terminalID];
    		ASP.resource.asp.mopp.AspContainedFeature[] containmentFeatures = new ASP.resource.asp.mopp.AspContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = ASP.resource.asp.grammar.AspFollowSetProvider.LINKS[ids[i]];
    		}
    		ASP.resource.asp.grammar.AspContainmentTrace containmentTrace = new ASP.resource.asp.grammar.AspContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		ASP.resource.asp.mopp.AspExpectedTerminal expectedElement = new ASP.resource.asp.mopp.AspExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		postParseCommands.add(new ASP.resource.asp.IAspCommand<ASP.resource.asp.IAspTextResource>() {
    			public boolean execute(ASP.resource.asp.IAspTextResource resource) {
    				ASP.resource.asp.IAspLocationMap locationMap = resource.getLocationMap();
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
    		postParseCommands.add(new ASP.resource.asp.IAspCommand<ASP.resource.asp.IAspTextResource>() {
    			public boolean execute(ASP.resource.asp.IAspTextResource resource) {
    				ASP.resource.asp.IAspLocationMap locationMap = resource.getLocationMap();
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
    	protected void setLocalizationEnd(java.util.Collection<ASP.resource.asp.IAspCommand<ASP.resource.asp.IAspTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new ASP.resource.asp.IAspCommand<ASP.resource.asp.IAspTextResource>() {
    			public boolean execute(ASP.resource.asp.IAspTextResource resource) {
    				ASP.resource.asp.IAspLocationMap locationMap = resource.getLocationMap();
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
    	
    	public ASP.resource.asp.IAspTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new AspParser(new org.antlr.runtime3_4_0.CommonTokenStream(new AspLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new AspParser(new org.antlr.runtime3_4_0.CommonTokenStream(new AspLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new ASP.resource.asp.util.AspRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public AspParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((AspLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((AspLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == ASP.Transformation.class) {
    				return parse_ASP_Transformation();
    			}
    			if (type.getInstanceClass() == ASP.Relation.class) {
    				return parse_ASP_Relation();
    			}
    			if (type.getInstanceClass() == ASP.LeftPattern.class) {
    				return parse_ASP_LeftPattern();
    			}
    			if (type.getInstanceClass() == ASP.RightPattern.class) {
    				return parse_ASP_RightPattern();
    			}
    			if (type.getInstanceClass() == ASP.Metanode.class) {
    				return parse_ASP_Metanode();
    			}
    			if (type.getInstanceClass() == ASP.Metaprop.class) {
    				return parse_ASP_Metaprop();
    			}
    			if (type.getInstanceClass() == ASP.Metaedge.class) {
    				return parse_ASP_Metaedge();
    			}
    			if (type.getInstanceClass() == ASP.Node.class) {
    				return parse_ASP_Node();
    			}
    			if (type.getInstanceClass() == ASP.Prop.class) {
    				return parse_ASP_Prop();
    			}
    			if (type.getInstanceClass() == ASP.Edge.class) {
    				return parse_ASP_Edge();
    			}
    			if (type.getInstanceClass() == ASP.Constraint.class) {
    				return parse_ASP_Constraint();
    			}
    			if (type.getInstanceClass() == ASP.Literal.class) {
    				return parse_ASP_Literal();
    			}
    			if (type.getInstanceClass() == ASP.Terminal.class) {
    				return parse_ASP_Terminal();
    			}
    			if (type.getInstanceClass() == ASP.Not.class) {
    				return parse_ASP_Not();
    			}
    			if (type.getInstanceClass() == ASP.Eq.class) {
    				return parse_ASP_Eq();
    			}
    			if (type.getInstanceClass() == ASP.NotEq.class) {
    				return parse_ASP_NotEq();
    			}
    		}
    		throw new ASP.resource.asp.mopp.AspUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(ASP.resource.asp.IAspOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public ASP.resource.asp.IAspParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<ASP.resource.asp.IAspCommand<ASP.resource.asp.IAspTextResource>>();
    		ASP.resource.asp.mopp.AspParseResult parseResult = new ASP.resource.asp.mopp.AspParseResult();
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
    	
    	public java.util.List<ASP.resource.asp.mopp.AspExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, ASP.resource.asp.IAspTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		ASP.resource.asp.IAspParseResult result = parse();
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
    			for (ASP.resource.asp.IAspCommand<ASP.resource.asp.IAspTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<ASP.resource.asp.mopp.AspExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<ASP.resource.asp.mopp.AspExpectedTerminal>();
    		java.util.List<ASP.resource.asp.mopp.AspExpectedTerminal> newFollowSet = new java.util.ArrayList<ASP.resource.asp.mopp.AspExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			ASP.resource.asp.mopp.AspExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 80;
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
    				for (ASP.resource.asp.mopp.AspExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (ASP.resource.asp.mopp.AspExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<ASP.resource.asp.util.AspPair<ASP.resource.asp.IAspExpectedElement, ASP.resource.asp.mopp.AspContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (ASP.resource.asp.util.AspPair<ASP.resource.asp.IAspExpectedElement, ASP.resource.asp.mopp.AspContainedFeature[]> newFollowerPair : newFollowers) {
    							ASP.resource.asp.IAspExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							ASP.resource.asp.grammar.AspContainmentTrace containmentTrace = new ASP.resource.asp.grammar.AspContainmentTrace(null, newFollowerPair.getRight());
    							ASP.resource.asp.mopp.AspExpectedTerminal newFollowTerminal = new ASP.resource.asp.mopp.AspExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (ASP.resource.asp.mopp.AspExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(ASP.resource.asp.mopp.AspExpectedTerminal expectedElement, int tokenIndex) {
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
    // Asp.g:544:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_ASP_Transformation ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        ASP.Transformation c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Asp.g:545:2: ( (c0= parse_ASP_Transformation ) EOF )
            // Asp.g:546:2: (c0= parse_ASP_Transformation ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[1]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[2]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[3]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[4]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[6]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[7]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[8]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[10]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Asp.g:561:2: (c0= parse_ASP_Transformation )
            // Asp.g:562:3: c0= parse_ASP_Transformation
            {
            pushFollow(FOLLOW_parse_ASP_Transformation_in_start82);
            c0=parse_ASP_Transformation();

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



    // $ANTLR start "parse_ASP_Transformation"
    // Asp.g:570:1: parse_ASP_Transformation returns [ASP.Transformation element = null] : ( (a0_0= parse_ASP_Element ) )+ ( (a1_0= parse_ASP_Relation ) )+ ( (a2_0= parse_ASP_Constraint ) )* ;
    public final ASP.Transformation parse_ASP_Transformation() throws RecognitionException {
        ASP.Transformation element =  null;

        int parse_ASP_Transformation_StartIndex = input.index();

        ASP.Element a0_0 =null;

        ASP.Relation a1_0 =null;

        ASP.Constraint a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Asp.g:573:2: ( ( (a0_0= parse_ASP_Element ) )+ ( (a1_0= parse_ASP_Relation ) )+ ( (a2_0= parse_ASP_Constraint ) )* )
            // Asp.g:574:2: ( (a0_0= parse_ASP_Element ) )+ ( (a1_0= parse_ASP_Relation ) )+ ( (a2_0= parse_ASP_Constraint ) )*
            {
            // Asp.g:574:2: ( (a0_0= parse_ASP_Element ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==TEXT||(LA1_0 >= 16 && LA1_0 <= 25)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Asp.g:575:3: (a0_0= parse_ASP_Element )
            	    {
            	    // Asp.g:575:3: (a0_0= parse_ASP_Element )
            	    // Asp.g:576:4: a0_0= parse_ASP_Element
            	    {
            	    pushFollow(FOLLOW_parse_ASP_Element_in_parse_ASP_Transformation124);
            	    a0_0=parse_ASP_Element();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = ASP.ASPFactory.eINSTANCE.createTransformation();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a0_0 != null) {
            	    					if (a0_0 != null) {
            	    						Object value = a0_0;
            	    						addObjectToList(element, ASP.ASPPackage.TRANSFORMATION__ELEMENTS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_0_0_0_0, a0_0, true);
            	    					copyLocalizationInfos(a0_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[11]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[12]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[13]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[14]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[15]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[16]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[17]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[18]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[19]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[20]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[21]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[22]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[23]);
            	}

            // Asp.g:614:2: ( (a1_0= parse_ASP_Relation ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= 26 && LA2_0 <= 28)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Asp.g:615:3: (a1_0= parse_ASP_Relation )
            	    {
            	    // Asp.g:615:3: (a1_0= parse_ASP_Relation )
            	    // Asp.g:616:4: a1_0= parse_ASP_Relation
            	    {
            	    pushFollow(FOLLOW_parse_ASP_Relation_in_parse_ASP_Transformation159);
            	    a1_0=parse_ASP_Relation();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = ASP.ASPFactory.eINSTANCE.createTransformation();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a1_0 != null) {
            	    					if (a1_0 != null) {
            	    						Object value = a1_0;
            	    						addObjectToList(element, ASP.ASPPackage.TRANSFORMATION__RELATIONS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_0_0_0_2, a1_0, true);
            	    					copyLocalizationInfos(a1_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[24]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[25]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[27]);
            	}

            // Asp.g:645:2: ( (a2_0= parse_ASP_Constraint ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==TEXT||LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Asp.g:646:3: (a2_0= parse_ASP_Constraint )
            	    {
            	    // Asp.g:646:3: (a2_0= parse_ASP_Constraint )
            	    // Asp.g:647:4: a2_0= parse_ASP_Constraint
            	    {
            	    pushFollow(FOLLOW_parse_ASP_Constraint_in_parse_ASP_Transformation194);
            	    a2_0=parse_ASP_Constraint();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = ASP.ASPFactory.eINSTANCE.createTransformation();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a2_0 != null) {
            	    					if (a2_0 != null) {
            	    						Object value = a2_0;
            	    						addObjectToList(element, ASP.ASPPackage.TRANSFORMATION__CONSTRAINTS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_0_0_0_4, a2_0, true);
            	    					copyLocalizationInfos(a2_0, element);
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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[28]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[29]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_ASP_Transformation_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Transformation"



    // $ANTLR start "parse_ASP_Relation"
    // Asp.g:676:1: parse_ASP_Relation returns [ASP.Relation element = null] : (a0_0= parse_ASP_Pattern ) (a1_0= parse_ASP_RightPattern ) ;
    public final ASP.Relation parse_ASP_Relation() throws RecognitionException {
        ASP.Relation element =  null;

        int parse_ASP_Relation_StartIndex = input.index();

        ASP.Pattern a0_0 =null;

        ASP.RightPattern a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Asp.g:679:2: ( (a0_0= parse_ASP_Pattern ) (a1_0= parse_ASP_RightPattern ) )
            // Asp.g:680:2: (a0_0= parse_ASP_Pattern ) (a1_0= parse_ASP_RightPattern )
            {
            // Asp.g:680:2: (a0_0= parse_ASP_Pattern )
            // Asp.g:681:3: a0_0= parse_ASP_Pattern
            {
            pushFollow(FOLLOW_parse_ASP_Pattern_in_parse_ASP_Relation239);
            a0_0=parse_ASP_Pattern();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createRelation();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, ASP.ASPPackage.RELATION__PATTERNS, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_1_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getRelation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[30]);
            	}

            // Asp.g:706:2: (a1_0= parse_ASP_RightPattern )
            // Asp.g:707:3: a1_0= parse_ASP_RightPattern
            {
            pushFollow(FOLLOW_parse_ASP_RightPattern_in_parse_ASP_Relation261);
            a1_0=parse_ASP_RightPattern();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createRelation();
            				startIncompleteElement(element);
            			}
            			if (a1_0 != null) {
            				if (a1_0 != null) {
            					Object value = a1_0;
            					addObjectToList(element, ASP.ASPPackage.RELATION__PATTERNS, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_1_0_0_2, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[31]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[32]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[33]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[34]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_ASP_Relation_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Relation"



    // $ANTLR start "parse_ASP_LeftPattern"
    // Asp.g:737:1: parse_ASP_LeftPattern returns [ASP.LeftPattern element = null] : ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) ) (a5= QUOTED_40_41 ) a6= '.' ;
    public final ASP.LeftPattern parse_ASP_LeftPattern() throws RecognitionException {
        ASP.LeftPattern element =  null;

        int parse_ASP_LeftPattern_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a5=null;
        Token a6=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Asp.g:740:2: ( ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) ) (a5= QUOTED_40_41 ) a6= '.' )
            // Asp.g:741:2: ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) ) (a5= QUOTED_40_41 ) a6= '.'
            {
            // Asp.g:741:2: ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) )
            // Asp.g:742:3: (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' )
            {
            // Asp.g:742:3: (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt4=1;
                }
                break;
            case 28:
                {
                alt4=2;
                }
                break;
            case 26:
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
                    // Asp.g:743:4: a0= 'relation_node'
                    {
                    a0=(Token)match(input,27,FOLLOW_27_in_parse_ASP_LeftPattern303); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createLeftPattern();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_2_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    				// set value of enumeration attribute
                    				Object value = ASP.ASPPackage.eINSTANCE.getRelationType().getEEnumLiteral(ASP.RelationType.NODE_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.LEFT_PATTERN__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Asp.g:756:8: a1= 'relation_prop'
                    {
                    a1=(Token)match(input,28,FOLLOW_28_in_parse_ASP_LeftPattern318); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createLeftPattern();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_2_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = ASP.ASPPackage.eINSTANCE.getRelationType().getEEnumLiteral(ASP.RelationType.PROP_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.LEFT_PATTERN__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Asp.g:769:8: a2= 'relation_edge'
                    {
                    a2=(Token)match(input,26,FOLLOW_26_in_parse_ASP_LeftPattern333); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createLeftPattern();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_2_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = ASP.ASPPackage.eINSTANCE.getRelationType().getEEnumLiteral(ASP.RelationType.EDGE_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.LEFT_PATTERN__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[35]);
            	}

            // Asp.g:789:2: (a5= QUOTED_40_41 )
            // Asp.g:790:3: a5= QUOTED_40_41
            {
            a5=(Token)match(input,QUOTED_40_41,FOLLOW_QUOTED_40_41_in_parse_ASP_LeftPattern358); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createLeftPattern();
            				startIncompleteElement(element);
            			}
            			if (a5 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_40_41");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.LEFT_PATTERN__ELEMENT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Function proxy = ASP.ASPFactory.eINSTANCE.createNode();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Pattern, ASP.Function>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPatternElementReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.LEFT_PATTERN__ELEMENT), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.LEFT_PATTERN__ELEMENT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_2_0_0_2, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[36]);
            	}

            a6=(Token)match(input,13,FOLLOW_13_in_parse_ASP_LeftPattern379); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createLeftPattern();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_2_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getRelation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[37]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_ASP_LeftPattern_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_LeftPattern"



    // $ANTLR start "parse_ASP_RightPattern"
    // Asp.g:845:1: parse_ASP_RightPattern returns [ASP.RightPattern element = null] : ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) ) (a5= QUOTED_40_41 ) a6= '.' ;
    public final ASP.RightPattern parse_ASP_RightPattern() throws RecognitionException {
        ASP.RightPattern element =  null;

        int parse_ASP_RightPattern_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a5=null;
        Token a6=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Asp.g:848:2: ( ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) ) (a5= QUOTED_40_41 ) a6= '.' )
            // Asp.g:849:2: ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) ) (a5= QUOTED_40_41 ) a6= '.'
            {
            // Asp.g:849:2: ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) )
            // Asp.g:850:3: (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' )
            {
            // Asp.g:850:3: (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt5=1;
                }
                break;
            case 28:
                {
                alt5=2;
                }
                break;
            case 26:
                {
                alt5=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // Asp.g:851:4: a0= 'relation_node'
                    {
                    a0=(Token)match(input,27,FOLLOW_27_in_parse_ASP_RightPattern417); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createRightPattern();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_3_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    				// set value of enumeration attribute
                    				Object value = ASP.ASPPackage.eINSTANCE.getRelationType().getEEnumLiteral(ASP.RelationType.NODE_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RIGHT_PATTERN__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Asp.g:864:8: a1= 'relation_prop'
                    {
                    a1=(Token)match(input,28,FOLLOW_28_in_parse_ASP_RightPattern432); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createRightPattern();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_3_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = ASP.ASPPackage.eINSTANCE.getRelationType().getEEnumLiteral(ASP.RelationType.PROP_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RIGHT_PATTERN__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Asp.g:877:8: a2= 'relation_edge'
                    {
                    a2=(Token)match(input,26,FOLLOW_26_in_parse_ASP_RightPattern447); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createRightPattern();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_3_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = ASP.ASPPackage.eINSTANCE.getRelationType().getEEnumLiteral(ASP.RelationType.EDGE_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RIGHT_PATTERN__TYPE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[38]);
            	}

            // Asp.g:897:2: (a5= QUOTED_40_41 )
            // Asp.g:898:3: a5= QUOTED_40_41
            {
            a5=(Token)match(input,QUOTED_40_41,FOLLOW_QUOTED_40_41_in_parse_ASP_RightPattern472); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createRightPattern();
            				startIncompleteElement(element);
            			}
            			if (a5 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_40_41");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.RIGHT_PATTERN__ELEMENT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Function proxy = ASP.ASPFactory.eINSTANCE.createNode();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Pattern, ASP.Function>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPatternElementReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.RIGHT_PATTERN__ELEMENT), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RIGHT_PATTERN__ELEMENT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_3_0_0_2, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[39]);
            	}

            a6=(Token)match(input,13,FOLLOW_13_in_parse_ASP_RightPattern493); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createRightPattern();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_3_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getRelation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[40]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_ASP_RightPattern_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_RightPattern"



    // $ANTLR start "parse_ASP_Metanode"
    // Asp.g:953:1: parse_ASP_Metanode returns [ASP.Metanode element = null] : a0= 'metanode(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ').' ;
    public final ASP.Metanode parse_ASP_Metanode() throws RecognitionException {
        ASP.Metanode element =  null;

        int parse_ASP_Metanode_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Asp.g:956:2: (a0= 'metanode(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ').' )
            // Asp.g:957:2: a0= 'metanode(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ').'
            {
            a0=(Token)match(input,19,FOLLOW_19_in_parse_ASP_Metanode522); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createMetanode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_4_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[41]);
            	}

            // Asp.g:971:2: (a1= TEXT )
            // Asp.g:972:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metanode540); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createMetanode();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.METANODE__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METANODE__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.METANODE__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_4_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[42]);
            	}

            a2=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Metanode561); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createMetanode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_4_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[43]);
            	}

            // Asp.g:1025:2: (a3= TEXT )
            // Asp.g:1026:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metanode579); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createMetanode();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.METANODE__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METANODE__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.METANODE__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_4_0_0_4, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[44]);
            	}

            a4=(Token)match(input,11,FOLLOW_11_in_parse_ASP_Metanode600); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createMetanode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_4_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[45]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[46]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[47]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[48]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[49]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[50]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[51]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[52]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[53]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[54]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[55]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[56]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[57]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_ASP_Metanode_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Metanode"



    // $ANTLR start "parse_ASP_Metaprop"
    // Asp.g:1093:1: parse_ASP_Metaprop returns [ASP.Metaprop element = null] : a0= 'metaprop(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ').' ;
    public final ASP.Metaprop parse_ASP_Metaprop() throws RecognitionException {
        ASP.Metaprop element =  null;

        int parse_ASP_Metaprop_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Asp.g:1096:2: (a0= 'metaprop(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ').' )
            // Asp.g:1097:2: a0= 'metaprop(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ').'
            {
            a0=(Token)match(input,20,FOLLOW_20_in_parse_ASP_Metaprop629); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createMetaprop();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_5_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[58]);
            	}

            // Asp.g:1111:2: (a1= TEXT )
            // Asp.g:1112:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metaprop647); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createMetaprop();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.METAPROP__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_5_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[59]);
            	}

            a2=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Metaprop668); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createMetaprop();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_5_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[60]);
            	}

            // Asp.g:1165:2: (a3= TEXT )
            // Asp.g:1166:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metaprop686); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createMetaprop();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.METAPROP__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_5_0_0_4, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[61]);
            	}

            a4=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Metaprop707); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createMetaprop();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_5_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[62]);
            	}

            // Asp.g:1219:2: (a5= TEXT )
            // Asp.g:1220:3: a5= TEXT
            {
            a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metaprop725); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createMetaprop();
            				startIncompleteElement(element);
            			}
            			if (a5 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.METAPROP__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_5_0_0_7, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[63]);
            	}

            a6=(Token)match(input,11,FOLLOW_11_in_parse_ASP_Metaprop746); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createMetaprop();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_5_0_0_8, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[64]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[65]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[66]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[67]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[68]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[69]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[70]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[71]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[72]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[73]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[74]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[75]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[76]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_ASP_Metaprop_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Metaprop"



    // $ANTLR start "parse_ASP_Metaedge"
    // Asp.g:1287:1: parse_ASP_Metaedge returns [ASP.Metaedge element = null] : a0= 'metaedge(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ').' ;
    public final ASP.Metaedge parse_ASP_Metaedge() throws RecognitionException {
        ASP.Metaedge element =  null;

        int parse_ASP_Metaedge_StartIndex = input.index();

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

            // Asp.g:1290:2: (a0= 'metaedge(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ').' )
            // Asp.g:1291:2: a0= 'metaedge(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ').'
            {
            a0=(Token)match(input,18,FOLLOW_18_in_parse_ASP_Metaedge775); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createMetaedge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_6_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[77]);
            	}

            // Asp.g:1305:2: (a1= TEXT )
            // Asp.g:1306:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metaedge793); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createMetaedge();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.METAEDGE__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_6_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[78]);
            	}

            a2=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Metaedge814); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createMetaedge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_6_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[79]);
            	}

            // Asp.g:1359:2: (a3= TEXT )
            // Asp.g:1360:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metaedge832); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createMetaedge();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.METAEDGE__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_6_0_0_4, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[80]);
            	}

            a4=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Metaedge853); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createMetaedge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_6_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[81]);
            	}

            // Asp.g:1413:2: (a5= TEXT )
            // Asp.g:1414:3: a5= TEXT
            {
            a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metaedge871); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createMetaedge();
            				startIncompleteElement(element);
            			}
            			if (a5 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.METAEDGE__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_6_0_0_7, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[82]);
            	}

            a6=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Metaedge892); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createMetaedge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_6_0_0_8, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[83]);
            	}

            // Asp.g:1467:2: (a7= TEXT )
            // Asp.g:1468:3: a7= TEXT
            {
            a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metaedge910); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createMetaedge();
            				startIncompleteElement(element);
            			}
            			if (a7 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.METAEDGE__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_6_0_0_10, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[84]);
            	}

            a8=(Token)match(input,11,FOLLOW_11_in_parse_ASP_Metaedge931); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createMetaedge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_6_0_0_11, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[85]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[86]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[87]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[88]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[89]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[90]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[91]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[92]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[93]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[94]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[95]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[96]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[97]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_ASP_Metaedge_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Metaedge"



    // $ANTLR start "parse_ASP_Node"
    // Asp.g:1535:1: parse_ASP_Node returns [ASP.Node element = null] : ( (a0= 'nodex(' |a1= 'node(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ').' ;
    public final ASP.Node parse_ASP_Node() throws RecognitionException {
        ASP.Node element =  null;

        int parse_ASP_Node_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Asp.g:1538:2: ( ( (a0= 'nodex(' |a1= 'node(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ').' )
            // Asp.g:1539:2: ( (a0= 'nodex(' |a1= 'node(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ').'
            {
            // Asp.g:1539:2: ( (a0= 'nodex(' |a1= 'node(' ) )
            // Asp.g:1540:3: (a0= 'nodex(' |a1= 'node(' )
            {
            // Asp.g:1540:3: (a0= 'nodex(' |a1= 'node(' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==22) ) {
                alt6=1;
            }
            else if ( (LA6_0==21) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // Asp.g:1541:4: a0= 'nodex('
                    {
                    a0=(Token)match(input,22,FOLLOW_22_in_parse_ASP_Node969); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createNode();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_7_0_0_0, true, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    				// set value of boolean attribute
                    				Object value = true;
                    				element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__IS_NODEX), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Asp.g:1554:8: a1= 'node('
                    {
                    a1=(Token)match(input,21,FOLLOW_21_in_parse_ASP_Node984); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createNode();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_7_0_0_0, false, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    				// set value of boolean attribute
                    				Object value = false;
                    				element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__IS_NODEX), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[98]);
            	}

            // Asp.g:1574:2: (a3= TEXT )
            // Asp.g:1575:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Node1009); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createNode();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.NODE__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_7_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[99]);
            	}

            a4=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Node1030); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_7_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[100]);
            	}

            // Asp.g:1628:2: (a5= TEXT )
            // Asp.g:1629:3: a5= TEXT
            {
            a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Node1048); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createNode();
            				startIncompleteElement(element);
            			}
            			if (a5 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.NODE__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_7_0_0_4, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[101]);
            	}

            a6=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Node1069); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_7_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[102]);
            	}

            // Asp.g:1682:2: (a7= TEXT )
            // Asp.g:1683:3: a7= TEXT
            {
            a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Node1087); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createNode();
            				startIncompleteElement(element);
            			}
            			if (a7 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.NODE__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_7_0_0_7, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[103]);
            	}

            a8=(Token)match(input,11,FOLLOW_11_in_parse_ASP_Node1108); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createNode();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_7_0_0_8, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[104]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[105]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[106]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[107]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[108]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[109]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[110]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[111]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[112]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[113]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[114]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[115]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[116]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_ASP_Node_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Node"



    // $ANTLR start "parse_ASP_Prop"
    // Asp.g:1750:1: parse_ASP_Prop returns [ASP.Prop element = null] : ( (a0= 'propx(' |a1= 'prop(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ',' (a9= TEXT ) a10= ').' ;
    public final ASP.Prop parse_ASP_Prop() throws RecognitionException {
        ASP.Prop element =  null;

        int parse_ASP_Prop_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Asp.g:1753:2: ( ( (a0= 'propx(' |a1= 'prop(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ',' (a9= TEXT ) a10= ').' )
            // Asp.g:1754:2: ( (a0= 'propx(' |a1= 'prop(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ',' (a9= TEXT ) a10= ').'
            {
            // Asp.g:1754:2: ( (a0= 'propx(' |a1= 'prop(' ) )
            // Asp.g:1755:3: (a0= 'propx(' |a1= 'prop(' )
            {
            // Asp.g:1755:3: (a0= 'propx(' |a1= 'prop(' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==25) ) {
                alt7=1;
            }
            else if ( (LA7_0==24) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // Asp.g:1756:4: a0= 'propx('
                    {
                    a0=(Token)match(input,25,FOLLOW_25_in_parse_ASP_Prop1146); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createProp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_8_0_0_0, true, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    				// set value of boolean attribute
                    				Object value = true;
                    				element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__IS_PROPX), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Asp.g:1769:8: a1= 'prop('
                    {
                    a1=(Token)match(input,24,FOLLOW_24_in_parse_ASP_Prop1161); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createProp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_8_0_0_0, false, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    				// set value of boolean attribute
                    				Object value = false;
                    				element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__IS_PROPX), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[117]);
            	}

            // Asp.g:1789:2: (a3= TEXT )
            // Asp.g:1790:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Prop1186); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createProp();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.PROP__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_8_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[118]);
            	}

            a4=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Prop1207); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_8_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[119]);
            	}

            // Asp.g:1843:2: (a5= TEXT )
            // Asp.g:1844:3: a5= TEXT
            {
            a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Prop1225); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createProp();
            				startIncompleteElement(element);
            			}
            			if (a5 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.PROP__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_8_0_0_4, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[120]);
            	}

            a6=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Prop1246); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_8_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[121]);
            	}

            // Asp.g:1897:2: (a7= TEXT )
            // Asp.g:1898:3: a7= TEXT
            {
            a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Prop1264); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createProp();
            				startIncompleteElement(element);
            			}
            			if (a7 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.PROP__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_8_0_0_7, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[122]);
            	}

            a8=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Prop1285); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_8_0_0_8, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[123]);
            	}

            // Asp.g:1951:2: (a9= TEXT )
            // Asp.g:1952:3: a9= TEXT
            {
            a9=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Prop1303); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createProp();
            				startIncompleteElement(element);
            			}
            			if (a9 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.PROP__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_8_0_0_10, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[124]);
            	}

            a10=(Token)match(input,11,FOLLOW_11_in_parse_ASP_Prop1324); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createProp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_8_0_0_11, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[125]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[126]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[127]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[128]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[129]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[130]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[131]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[132]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[133]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[134]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[135]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[136]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[137]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parse_ASP_Prop_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Prop"



    // $ANTLR start "parse_ASP_Edge"
    // Asp.g:2019:1: parse_ASP_Edge returns [ASP.Edge element = null] : ( (a0= 'edgex(' |a1= 'edge(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ',' (a9= TEXT ) a10= ',' (a11= TEXT ) a12= ').' ;
    public final ASP.Edge parse_ASP_Edge() throws RecognitionException {
        ASP.Edge element =  null;

        int parse_ASP_Edge_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
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



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Asp.g:2022:2: ( ( (a0= 'edgex(' |a1= 'edge(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ',' (a9= TEXT ) a10= ',' (a11= TEXT ) a12= ').' )
            // Asp.g:2023:2: ( (a0= 'edgex(' |a1= 'edge(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ',' (a9= TEXT ) a10= ',' (a11= TEXT ) a12= ').'
            {
            // Asp.g:2023:2: ( (a0= 'edgex(' |a1= 'edge(' ) )
            // Asp.g:2024:3: (a0= 'edgex(' |a1= 'edge(' )
            {
            // Asp.g:2024:3: (a0= 'edgex(' |a1= 'edge(' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            else if ( (LA8_0==16) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // Asp.g:2025:4: a0= 'edgex('
                    {
                    a0=(Token)match(input,17,FOLLOW_17_in_parse_ASP_Edge1362); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createEdge();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_0, true, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    				// set value of boolean attribute
                    				Object value = true;
                    				element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__IS_EDGEX), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Asp.g:2038:8: a1= 'edge('
                    {
                    a1=(Token)match(input,16,FOLLOW_16_in_parse_ASP_Edge1377); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createEdge();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_0, false, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    				// set value of boolean attribute
                    				Object value = false;
                    				element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__IS_EDGEX), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[138]);
            	}

            // Asp.g:2058:2: (a3= TEXT )
            // Asp.g:2059:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Edge1402); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createEdge();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.EDGE__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_1, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[139]);
            	}

            a4=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Edge1423); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[140]);
            	}

            // Asp.g:2112:2: (a5= TEXT )
            // Asp.g:2113:3: a5= TEXT
            {
            a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Edge1441); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createEdge();
            				startIncompleteElement(element);
            			}
            			if (a5 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.EDGE__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_4, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[141]);
            	}

            a6=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Edge1462); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[142]);
            	}

            // Asp.g:2166:2: (a7= TEXT )
            // Asp.g:2167:3: a7= TEXT
            {
            a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Edge1480); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createEdge();
            				startIncompleteElement(element);
            			}
            			if (a7 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.EDGE__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_7, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[143]);
            	}

            a8=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Edge1501); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_8, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[144]);
            	}

            // Asp.g:2220:2: (a9= TEXT )
            // Asp.g:2221:3: a9= TEXT
            {
            a9=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Edge1519); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createEdge();
            				startIncompleteElement(element);
            			}
            			if (a9 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.EDGE__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_10, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[145]);
            	}

            a10=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Edge1540); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_11, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[146]);
            	}

            // Asp.g:2274:2: (a11= TEXT )
            // Asp.g:2275:3: a11= TEXT
            {
            a11=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Edge1558); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createEdge();
            				startIncompleteElement(element);
            			}
            			if (a11 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a11).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a11).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.EDGE__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_13, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a11, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a11, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[147]);
            	}

            a12=(Token)match(input,11,FOLLOW_11_in_parse_ASP_Edge1579); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createEdge();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_14, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[148]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[149]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[150]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[151]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[152]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[153]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[154]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[155]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[156]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[157]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[158]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[159]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[160]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, parse_ASP_Edge_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Edge"



    // $ANTLR start "parse_ASP_Constraint"
    // Asp.g:2342:1: parse_ASP_Constraint returns [ASP.Constraint element = null] : ( ( (a0= TEXT ) ) )? a1= ':-' (a2_0= parse_ASP_Expression ) ( (a3= ',' (a4_0= parse_ASP_Expression ) ) )* a5= '.' ;
    public final ASP.Constraint parse_ASP_Constraint() throws RecognitionException {
        ASP.Constraint element =  null;

        int parse_ASP_Constraint_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a5=null;
        ASP.Expression a2_0 =null;

        ASP.Expression a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Asp.g:2345:2: ( ( ( (a0= TEXT ) ) )? a1= ':-' (a2_0= parse_ASP_Expression ) ( (a3= ',' (a4_0= parse_ASP_Expression ) ) )* a5= '.' )
            // Asp.g:2346:2: ( ( (a0= TEXT ) ) )? a1= ':-' (a2_0= parse_ASP_Expression ) ( (a3= ',' (a4_0= parse_ASP_Expression ) ) )* a5= '.'
            {
            // Asp.g:2346:2: ( ( (a0= TEXT ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==TEXT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Asp.g:2347:3: ( (a0= TEXT ) )
                    {
                    // Asp.g:2347:3: ( (a0= TEXT ) )
                    // Asp.g:2348:4: (a0= TEXT )
                    {
                    // Asp.g:2348:4: (a0= TEXT )
                    // Asp.g:2349:5: a0= TEXT
                    {
                    a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Constraint1623); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new ASP.resource.asp.mopp.AspTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = ASP.ASPFactory.eINSTANCE.createConstraint();
                    						startIncompleteElement(element);
                    					}
                    					if (a0 != null) {
                    						ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    						tokenResolver.setOptions(getOptions());
                    						ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
                    						tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__COMMENT), result);
                    						Object resolvedObject = result.getResolvedToken();
                    						if (resolvedObject == null) {
                    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
                    						}
                    						java.lang.String resolved = (java.lang.String) resolvedObject;
                    						if (resolved != null) {
                    							Object value = resolved;
                    							element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__COMMENT), value);
                    							completedElement(value, false);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_0_0_0_0, resolved, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[161]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[162]);
            	}

            a1=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Constraint1669); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createConstraint();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[163]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[164]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[165]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[166]);
            	}

            // Asp.g:2408:2: (a2_0= parse_ASP_Expression )
            // Asp.g:2409:3: a2_0= parse_ASP_Expression
            {
            pushFollow(FOLLOW_parse_ASP_Expression_in_parse_ASP_Constraint1687);
            a2_0=parse_ASP_Expression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createConstraint();
            				startIncompleteElement(element);
            			}
            			if (a2_0 != null) {
            				if (a2_0 != null) {
            					Object value = a2_0;
            					addObjectToList(element, ASP.ASPPackage.CONSTRAINT__EXPRESSIONS, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_3, a2_0, true);
            				copyLocalizationInfos(a2_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[167]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[168]);
            	}

            // Asp.g:2435:2: ( (a3= ',' (a4_0= parse_ASP_Expression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==12) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Asp.g:2436:3: (a3= ',' (a4_0= parse_ASP_Expression ) )
            	    {
            	    // Asp.g:2436:3: (a3= ',' (a4_0= parse_ASP_Expression ) )
            	    // Asp.g:2437:4: a3= ',' (a4_0= parse_ASP_Expression )
            	    {
            	    a3=(Token)match(input,12,FOLLOW_12_in_parse_ASP_Constraint1714); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = ASP.ASPFactory.eINSTANCE.createConstraint();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_4_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[169]);
            	    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[170]);
            	    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[171]);
            	    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[172]);
            	    			}

            	    // Asp.g:2454:4: (a4_0= parse_ASP_Expression )
            	    // Asp.g:2455:5: a4_0= parse_ASP_Expression
            	    {
            	    pushFollow(FOLLOW_parse_ASP_Expression_in_parse_ASP_Constraint1740);
            	    a4_0=parse_ASP_Expression();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = ASP.ASPFactory.eINSTANCE.createConstraint();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a4_0 != null) {
            	    						if (a4_0 != null) {
            	    							Object value = a4_0;
            	    							addObjectToList(element, ASP.ASPPackage.CONSTRAINT__EXPRESSIONS, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_4_0_0_2, a4_0, true);
            	    						copyLocalizationInfos(a4_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[173]);
            	    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[174]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[175]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[176]);
            	}

            a5=(Token)match(input,13,FOLLOW_13_in_parse_ASP_Constraint1781); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createConstraint();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[177]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[178]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, parse_ASP_Constraint_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Constraint"



    // $ANTLR start "parse_ASP_Literal"
    // Asp.g:2506:1: parse_ASP_Literal returns [ASP.Literal element = null] : (a0= TEXT ) ( (a1= '.' ) )? ;
    public final ASP.Literal parse_ASP_Literal() throws RecognitionException {
        ASP.Literal element =  null;

        int parse_ASP_Literal_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Asp.g:2509:2: ( (a0= TEXT ) ( (a1= '.' ) )? )
            // Asp.g:2510:2: (a0= TEXT ) ( (a1= '.' ) )?
            {
            // Asp.g:2510:2: (a0= TEXT )
            // Asp.g:2511:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Literal1814); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createLiteral();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.LITERAL__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.LITERAL__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_11_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[179]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[180]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[181]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[182]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[183]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[184]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[185]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[186]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[187]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[188]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[189]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[190]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[191]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[192]);
            	}

            // Asp.g:2559:2: ( (a1= '.' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==13) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // Asp.g:2560:3: (a1= '.' )
                    {
                    // Asp.g:2560:3: (a1= '.' )
                    // Asp.g:2561:4: a1= '.'
                    {
                    a1=(Token)match(input,13,FOLLOW_13_in_parse_ASP_Literal1844); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_11_0_0_1_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[193]);
                    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[194]);
                    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[195]);
                    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[196]);
                    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[197]);
                    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[198]);
                    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[199]);
                    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[200]);
                    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[201]);
                    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[202]);
                    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[203]);
                    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[204]);
                    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[205]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[206]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[207]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[208]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[209]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[210]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[211]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[212]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[213]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[214]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[215]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[216]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[217]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[218]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, parse_ASP_Literal_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Literal"



    // $ANTLR start "parse_ASP_Terminal"
    // Asp.g:2608:1: parse_ASP_Terminal returns [ASP.Terminal element = null] : (a0= TEXT ) ;
    public final ASP.Terminal parse_ASP_Terminal() throws RecognitionException {
        ASP.Terminal element =  null;

        int parse_ASP_Terminal_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Asp.g:2611:2: ( (a0= TEXT ) )
            // Asp.g:2612:2: (a0= TEXT )
            {
            // Asp.g:2612:2: (a0= TEXT )
            // Asp.g:2613:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Terminal1896); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createTerminal();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.TERMINAL__ELEMENT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Element proxy = ASP.ASPFactory.eINSTANCE.createNot();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Terminal, ASP.Element>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalElementReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.TERMINAL__ELEMENT), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.TERMINAL__ELEMENT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_12_0_0_0, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[219]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[220]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[221]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[222]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[223]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[224]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[225]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[226]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[227]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[228]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[229]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[230]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[231]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[232]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[233]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, parse_ASP_Terminal_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Terminal"



    // $ANTLR start "parse_ASP_Not"
    // Asp.g:2668:1: parse_ASP_Not returns [ASP.Not element = null] : a0= 'not' (a1= TEXT ) ;
    public final ASP.Not parse_ASP_Not() throws RecognitionException {
        ASP.Not element =  null;

        int parse_ASP_Not_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Asp.g:2671:2: (a0= 'not' (a1= TEXT ) )
            // Asp.g:2672:2: a0= 'not' (a1= TEXT )
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_ASP_Not1932); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createNot();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_13_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[234]);
            	}

            // Asp.g:2686:2: (a1= TEXT )
            // Asp.g:2687:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Not1950); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createNot();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT__ELEMENT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Element proxy = ASP.ASPFactory.eINSTANCE.createNot();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Not, ASP.Element>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getNotElementReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT__ELEMENT), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT__ELEMENT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_13_0_0_2, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[235]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[236]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[237]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[238]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[239]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[240]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[241]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[242]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[243]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[244]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[245]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[246]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[247]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[248]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[249]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, parse_ASP_Not_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Not"



    // $ANTLR start "parse_ASP_Eq"
    // Asp.g:2742:1: parse_ASP_Eq returns [ASP.Eq element = null] : (a0= TEXT ) a1= '==' (a2= TEXT ) ;
    public final ASP.Eq parse_ASP_Eq() throws RecognitionException {
        ASP.Eq element =  null;

        int parse_ASP_Eq_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Asp.g:2745:2: ( (a0= TEXT ) a1= '==' (a2= TEXT ) )
            // Asp.g:2746:2: (a0= TEXT ) a1= '==' (a2= TEXT )
            {
            // Asp.g:2746:2: (a0= TEXT )
            // Asp.g:2747:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Eq1990); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createEq();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__LEFT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Eq, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEqLeftReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__LEFT), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__LEFT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_14_0_0_0, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[250]);
            	}

            a1=(Token)match(input,15,FOLLOW_15_in_parse_ASP_Eq2011); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createEq();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_14_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[251]);
            	}

            // Asp.g:2800:2: (a2= TEXT )
            // Asp.g:2801:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Eq2029); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createEq();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__RIGHT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Eq, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEqRightReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__RIGHT), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__RIGHT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_14_0_0_4, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[252]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[253]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[254]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[255]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[256]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[257]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[258]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[259]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[260]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[261]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[262]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[263]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[264]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[265]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[266]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, parse_ASP_Eq_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Eq"



    // $ANTLR start "parse_ASP_NotEq"
    // Asp.g:2856:1: parse_ASP_NotEq returns [ASP.NotEq element = null] : (a0= TEXT ) a1= '!=' (a2= TEXT ) ;
    public final ASP.NotEq parse_ASP_NotEq() throws RecognitionException {
        ASP.NotEq element =  null;

        int parse_ASP_NotEq_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Asp.g:2859:2: ( (a0= TEXT ) a1= '!=' (a2= TEXT ) )
            // Asp.g:2860:2: (a0= TEXT ) a1= '!=' (a2= TEXT )
            {
            // Asp.g:2860:2: (a0= TEXT )
            // Asp.g:2861:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_NotEq2069); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createNotEq();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__LEFT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.NotEq, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getNotEqLeftReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__LEFT), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__LEFT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_15_0_0_0, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[267]);
            	}

            a1=(Token)match(input,10,FOLLOW_10_in_parse_ASP_NotEq2090); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createNotEq();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_15_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[268]);
            	}

            // Asp.g:2914:2: (a2= TEXT )
            // Asp.g:2915:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_NotEq2108); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createNotEq();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__RIGHT), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.NotEq, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getNotEqRightReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__RIGHT), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__RIGHT), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_15_0_0_4, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[269]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[270]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[271]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[272]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[273]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[274]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[275]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[276]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[277]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[278]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[279]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[280]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[281]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[282]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[283]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, parse_ASP_NotEq_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_NotEq"



    // $ANTLR start "parse_ASP_Element"
    // Asp.g:2970:1: parse_ASP_Element returns [ASP.Element element = null] : (c0= parse_ASP_Metanode |c1= parse_ASP_Metaprop |c2= parse_ASP_Metaedge |c3= parse_ASP_Node |c4= parse_ASP_Prop |c5= parse_ASP_Edge |c6= parse_ASP_Literal |c7= parse_ASP_Terminal |c8= parse_ASP_Not |c9= parse_ASP_Eq |c10= parse_ASP_NotEq );
    public final ASP.Element parse_ASP_Element() throws RecognitionException {
        ASP.Element element =  null;

        int parse_ASP_Element_StartIndex = input.index();

        ASP.Metanode c0 =null;

        ASP.Metaprop c1 =null;

        ASP.Metaedge c2 =null;

        ASP.Node c3 =null;

        ASP.Prop c4 =null;

        ASP.Edge c5 =null;

        ASP.Literal c6 =null;

        ASP.Terminal c7 =null;

        ASP.Not c8 =null;

        ASP.Eq c9 =null;

        ASP.NotEq c10 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Asp.g:2971:2: (c0= parse_ASP_Metanode |c1= parse_ASP_Metaprop |c2= parse_ASP_Metaedge |c3= parse_ASP_Node |c4= parse_ASP_Prop |c5= parse_ASP_Edge |c6= parse_ASP_Literal |c7= parse_ASP_Terminal |c8= parse_ASP_Not |c9= parse_ASP_Eq |c10= parse_ASP_NotEq )
            int alt12=11;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt12=1;
                }
                break;
            case 20:
                {
                alt12=2;
                }
                break;
            case 18:
                {
                alt12=3;
                }
                break;
            case 21:
            case 22:
                {
                alt12=4;
                }
                break;
            case 24:
            case 25:
                {
                alt12=5;
                }
                break;
            case 16:
            case 17:
                {
                alt12=6;
                }
                break;
            case TEXT:
                {
                int LA12_7 = input.LA(2);

                if ( (LA12_7==15) ) {
                    alt12=10;
                }
                else if ( (LA12_7==10) ) {
                    alt12=11;
                }
                else if ( (synpred20_Asp()) ) {
                    alt12=7;
                }
                else if ( (synpred21_Asp()) ) {
                    alt12=8;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 7, input);

                    throw nvae;

                }
                }
                break;
            case 23:
                {
                alt12=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // Asp.g:2972:2: c0= parse_ASP_Metanode
                    {
                    pushFollow(FOLLOW_parse_ASP_Metanode_in_parse_ASP_Element2140);
                    c0=parse_ASP_Metanode();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Asp.g:2973:4: c1= parse_ASP_Metaprop
                    {
                    pushFollow(FOLLOW_parse_ASP_Metaprop_in_parse_ASP_Element2150);
                    c1=parse_ASP_Metaprop();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Asp.g:2974:4: c2= parse_ASP_Metaedge
                    {
                    pushFollow(FOLLOW_parse_ASP_Metaedge_in_parse_ASP_Element2160);
                    c2=parse_ASP_Metaedge();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Asp.g:2975:4: c3= parse_ASP_Node
                    {
                    pushFollow(FOLLOW_parse_ASP_Node_in_parse_ASP_Element2170);
                    c3=parse_ASP_Node();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Asp.g:2976:4: c4= parse_ASP_Prop
                    {
                    pushFollow(FOLLOW_parse_ASP_Prop_in_parse_ASP_Element2180);
                    c4=parse_ASP_Prop();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Asp.g:2977:4: c5= parse_ASP_Edge
                    {
                    pushFollow(FOLLOW_parse_ASP_Edge_in_parse_ASP_Element2190);
                    c5=parse_ASP_Edge();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Asp.g:2978:4: c6= parse_ASP_Literal
                    {
                    pushFollow(FOLLOW_parse_ASP_Literal_in_parse_ASP_Element2200);
                    c6=parse_ASP_Literal();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Asp.g:2979:4: c7= parse_ASP_Terminal
                    {
                    pushFollow(FOLLOW_parse_ASP_Terminal_in_parse_ASP_Element2210);
                    c7=parse_ASP_Terminal();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Asp.g:2980:4: c8= parse_ASP_Not
                    {
                    pushFollow(FOLLOW_parse_ASP_Not_in_parse_ASP_Element2220);
                    c8=parse_ASP_Not();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c8; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 10 :
                    // Asp.g:2981:4: c9= parse_ASP_Eq
                    {
                    pushFollow(FOLLOW_parse_ASP_Eq_in_parse_ASP_Element2230);
                    c9=parse_ASP_Eq();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c9; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 11 :
                    // Asp.g:2982:4: c10= parse_ASP_NotEq
                    {
                    pushFollow(FOLLOW_parse_ASP_NotEq_in_parse_ASP_Element2240);
                    c10=parse_ASP_NotEq();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c10; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 18, parse_ASP_Element_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Element"



    // $ANTLR start "parse_ASP_Pattern"
    // Asp.g:2986:1: parse_ASP_Pattern returns [ASP.Pattern element = null] : (c0= parse_ASP_LeftPattern |c1= parse_ASP_RightPattern );
    public final ASP.Pattern parse_ASP_Pattern() throws RecognitionException {
        ASP.Pattern element =  null;

        int parse_ASP_Pattern_StartIndex = input.index();

        ASP.LeftPattern c0 =null;

        ASP.RightPattern c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Asp.g:2987:2: (c0= parse_ASP_LeftPattern |c1= parse_ASP_RightPattern )
            int alt13=2;
            switch ( input.LA(1) ) {
            case 27:
                {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==QUOTED_40_41) ) {
                    int LA13_4 = input.LA(3);

                    if ( (LA13_4==13) ) {
                        int LA13_5 = input.LA(4);

                        if ( (synpred24_Asp()) ) {
                            alt13=1;
                        }
                        else if ( (true) ) {
                            alt13=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 5, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 4, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;

                }
                }
                break;
            case 28:
                {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==QUOTED_40_41) ) {
                    int LA13_4 = input.LA(3);

                    if ( (LA13_4==13) ) {
                        int LA13_5 = input.LA(4);

                        if ( (synpred24_Asp()) ) {
                            alt13=1;
                        }
                        else if ( (true) ) {
                            alt13=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 5, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 4, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;

                }
                }
                break;
            case 26:
                {
                int LA13_3 = input.LA(2);

                if ( (LA13_3==QUOTED_40_41) ) {
                    int LA13_4 = input.LA(3);

                    if ( (LA13_4==13) ) {
                        int LA13_5 = input.LA(4);

                        if ( (synpred24_Asp()) ) {
                            alt13=1;
                        }
                        else if ( (true) ) {
                            alt13=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 5, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 4, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }

            switch (alt13) {
                case 1 :
                    // Asp.g:2988:2: c0= parse_ASP_LeftPattern
                    {
                    pushFollow(FOLLOW_parse_ASP_LeftPattern_in_parse_ASP_Pattern2261);
                    c0=parse_ASP_LeftPattern();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Asp.g:2989:4: c1= parse_ASP_RightPattern
                    {
                    pushFollow(FOLLOW_parse_ASP_RightPattern_in_parse_ASP_Pattern2271);
                    c1=parse_ASP_RightPattern();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 19, parse_ASP_Pattern_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Pattern"



    // $ANTLR start "parse_ASP_Expression"
    // Asp.g:2993:1: parse_ASP_Expression returns [ASP.Expression element = null] : (c0= parse_ASP_Terminal |c1= parse_ASP_Not |c2= parse_ASP_Eq |c3= parse_ASP_NotEq );
    public final ASP.Expression parse_ASP_Expression() throws RecognitionException {
        ASP.Expression element =  null;

        int parse_ASP_Expression_StartIndex = input.index();

        ASP.Terminal c0 =null;

        ASP.Not c1 =null;

        ASP.Eq c2 =null;

        ASP.NotEq c3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Asp.g:2994:2: (c0= parse_ASP_Terminal |c1= parse_ASP_Not |c2= parse_ASP_Eq |c3= parse_ASP_NotEq )
            int alt14=4;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==TEXT) ) {
                switch ( input.LA(2) ) {
                case EOF:
                case 12:
                case 13:
                    {
                    alt14=1;
                    }
                    break;
                case 15:
                    {
                    alt14=3;
                    }
                    break;
                case 10:
                    {
                    alt14=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;

                }

            }
            else if ( (LA14_0==23) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // Asp.g:2995:2: c0= parse_ASP_Terminal
                    {
                    pushFollow(FOLLOW_parse_ASP_Terminal_in_parse_ASP_Expression2292);
                    c0=parse_ASP_Terminal();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Asp.g:2996:4: c1= parse_ASP_Not
                    {
                    pushFollow(FOLLOW_parse_ASP_Not_in_parse_ASP_Expression2302);
                    c1=parse_ASP_Not();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Asp.g:2997:4: c2= parse_ASP_Eq
                    {
                    pushFollow(FOLLOW_parse_ASP_Eq_in_parse_ASP_Expression2312);
                    c2=parse_ASP_Eq();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Asp.g:2998:4: c3= parse_ASP_NotEq
                    {
                    pushFollow(FOLLOW_parse_ASP_NotEq_in_parse_ASP_Expression2322);
                    c3=parse_ASP_NotEq();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 20, parse_ASP_Expression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Expression"

    // $ANTLR start synpred20_Asp
    public final void synpred20_Asp_fragment() throws RecognitionException {
        ASP.Literal c6 =null;


        // Asp.g:2978:4: (c6= parse_ASP_Literal )
        // Asp.g:2978:4: c6= parse_ASP_Literal
        {
        pushFollow(FOLLOW_parse_ASP_Literal_in_synpred20_Asp2200);
        c6=parse_ASP_Literal();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred20_Asp

    // $ANTLR start synpred21_Asp
    public final void synpred21_Asp_fragment() throws RecognitionException {
        ASP.Terminal c7 =null;


        // Asp.g:2979:4: (c7= parse_ASP_Terminal )
        // Asp.g:2979:4: c7= parse_ASP_Terminal
        {
        pushFollow(FOLLOW_parse_ASP_Terminal_in_synpred21_Asp2210);
        c7=parse_ASP_Terminal();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred21_Asp

    // $ANTLR start synpred24_Asp
    public final void synpred24_Asp_fragment() throws RecognitionException {
        ASP.LeftPattern c0 =null;


        // Asp.g:2988:2: (c0= parse_ASP_LeftPattern )
        // Asp.g:2988:2: c0= parse_ASP_LeftPattern
        {
        pushFollow(FOLLOW_parse_ASP_LeftPattern_in_synpred24_Asp2261);
        c0=parse_ASP_LeftPattern();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred24_Asp

    // Delegated rules

    public final boolean synpred24_Asp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_Asp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_Asp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_Asp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_Asp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_Asp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_parse_ASP_Transformation_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Element_in_parse_ASP_Transformation124 = new BitSet(new long[]{0x000000001FFF0100L});
    public static final BitSet FOLLOW_parse_ASP_Relation_in_parse_ASP_Transformation159 = new BitSet(new long[]{0x000000001C004102L});
    public static final BitSet FOLLOW_parse_ASP_Constraint_in_parse_ASP_Transformation194 = new BitSet(new long[]{0x0000000000004102L});
    public static final BitSet FOLLOW_parse_ASP_Pattern_in_parse_ASP_Relation239 = new BitSet(new long[]{0x000000001C000000L});
    public static final BitSet FOLLOW_parse_ASP_RightPattern_in_parse_ASP_Relation261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_parse_ASP_LeftPattern303 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_28_in_parse_ASP_LeftPattern318 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_26_in_parse_ASP_LeftPattern333 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_40_41_in_parse_ASP_LeftPattern358 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_ASP_LeftPattern379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_parse_ASP_RightPattern417 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_28_in_parse_ASP_RightPattern432 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_26_in_parse_ASP_RightPattern447 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_40_41_in_parse_ASP_RightPattern472 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_ASP_RightPattern493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_parse_ASP_Metanode522 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metanode540 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Metanode561 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metanode579 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASP_Metanode600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_ASP_Metaprop629 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metaprop647 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Metaprop668 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metaprop686 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Metaprop707 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metaprop725 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASP_Metaprop746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_parse_ASP_Metaedge775 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metaedge793 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Metaedge814 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metaedge832 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Metaedge853 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metaedge871 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Metaedge892 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metaedge910 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASP_Metaedge931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_parse_ASP_Node969 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_21_in_parse_ASP_Node984 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Node1009 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Node1030 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Node1048 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Node1069 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Node1087 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASP_Node1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_parse_ASP_Prop1146 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_24_in_parse_ASP_Prop1161 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Prop1186 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Prop1207 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Prop1225 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Prop1246 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Prop1264 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Prop1285 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Prop1303 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASP_Prop1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_ASP_Edge1362 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_16_in_parse_ASP_Edge1377 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Edge1402 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Edge1423 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Edge1441 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Edge1462 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Edge1480 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Edge1501 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Edge1519 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Edge1540 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Edge1558 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASP_Edge1579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Constraint1623 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Constraint1669 = new BitSet(new long[]{0x0000000000800100L});
    public static final BitSet FOLLOW_parse_ASP_Expression_in_parse_ASP_Constraint1687 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_Constraint1714 = new BitSet(new long[]{0x0000000000800100L});
    public static final BitSet FOLLOW_parse_ASP_Expression_in_parse_ASP_Constraint1740 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_13_in_parse_ASP_Constraint1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Literal1814 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_parse_ASP_Literal1844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Terminal1896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_ASP_Not1932 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Not1950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Eq1990 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_ASP_Eq2011 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Eq2029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_NotEq2069 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASP_NotEq2090 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_NotEq2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Metanode_in_parse_ASP_Element2140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Metaprop_in_parse_ASP_Element2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Metaedge_in_parse_ASP_Element2160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Node_in_parse_ASP_Element2170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Prop_in_parse_ASP_Element2180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Edge_in_parse_ASP_Element2190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Literal_in_parse_ASP_Element2200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Terminal_in_parse_ASP_Element2210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Not_in_parse_ASP_Element2220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Eq_in_parse_ASP_Element2230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_NotEq_in_parse_ASP_Element2240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_LeftPattern_in_parse_ASP_Pattern2261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_RightPattern_in_parse_ASP_Pattern2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Terminal_in_parse_ASP_Expression2292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Not_in_parse_ASP_Expression2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Eq_in_parse_ASP_Expression2312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_NotEq_in_parse_ASP_Expression2322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Literal_in_synpred20_Asp2200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Terminal_in_synpred21_Asp2210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_LeftPattern_in_synpred24_Asp2261 = new BitSet(new long[]{0x0000000000000002L});

}