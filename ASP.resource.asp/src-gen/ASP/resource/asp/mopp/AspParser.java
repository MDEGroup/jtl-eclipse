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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "ELEMENT", "LINEBREAK", "QUOTED_40_41", "TEXT", "WHITESPACE", "'!='", "'('", "')'", "').'", "','", "'.'", "':-'", "'=='", "'edge('", "'edgex('", "'metaedge('", "'metanode('", "'metaprop('", "'mmt='", "'node('", "'nodex('", "'not'", "'prop('", "'propx('", "'relation_edge'", "'relation_node'", "'relation_prop'"
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
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
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
        this.state.initializeRuleMemo(56 + 1);
         

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
    			if (type.getInstanceClass() == ASP.NamedFunction.class) {
    				return parse_ASP_NamedFunction();
    			}
    			if (type.getInstanceClass() == ASP.Rule.class) {
    				return parse_ASP_Rule();
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
    		int followSetID = 105;
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
    // Asp.g:550:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_ASP_Transformation ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        ASP.Transformation c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Asp.g:551:2: ( (c0= parse_ASP_Transformation ) EOF )
            // Asp.g:552:2: (c0= parse_ASP_Transformation ) EOF
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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[11]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Asp.g:568:2: (c0= parse_ASP_Transformation )
            // Asp.g:569:3: c0= parse_ASP_Transformation
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
    // Asp.g:577:1: parse_ASP_Transformation returns [ASP.Transformation element = null] : ( (a0_0= parse_ASP_Element ) )+ ( (a1_0= parse_ASP_Relation ) )+ ( (a2_0= parse_ASP_Rule ) )* ( (a3_0= parse_ASP_Constraint ) )* ;
    public final ASP.Transformation parse_ASP_Transformation() throws RecognitionException {
        ASP.Transformation element =  null;

        int parse_ASP_Transformation_StartIndex = input.index();

        ASP.Element a0_0 =null;

        ASP.Relation a1_0 =null;

        ASP.Rule a2_0 =null;

        ASP.Constraint a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Asp.g:580:2: ( ( (a0_0= parse_ASP_Element ) )+ ( (a1_0= parse_ASP_Relation ) )+ ( (a2_0= parse_ASP_Rule ) )* ( (a3_0= parse_ASP_Constraint ) )* )
            // Asp.g:581:2: ( (a0_0= parse_ASP_Element ) )+ ( (a1_0= parse_ASP_Relation ) )+ ( (a2_0= parse_ASP_Rule ) )* ( (a3_0= parse_ASP_Constraint ) )*
            {
            // Asp.g:581:2: ( (a0_0= parse_ASP_Element ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==TEXT||(LA1_0 >= 18 && LA1_0 <= 22)||(LA1_0 >= 24 && LA1_0 <= 28)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Asp.g:582:3: (a0_0= parse_ASP_Element )
            	    {
            	    // Asp.g:582:3: (a0_0= parse_ASP_Element )
            	    // Asp.g:583:4: a0_0= parse_ASP_Element
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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[24]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[25]);
            	}

            // Asp.g:622:2: ( (a1_0= parse_ASP_Relation ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= 29 && LA2_0 <= 31)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Asp.g:623:3: (a1_0= parse_ASP_Relation )
            	    {
            	    // Asp.g:623:3: (a1_0= parse_ASP_Relation )
            	    // Asp.g:624:4: a1_0= parse_ASP_Relation
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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[27]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[28]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[29]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[30]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[31]);
            	}

            // Asp.g:655:2: ( (a2_0= parse_ASP_Rule ) )*
            loop3:
            do {
                int alt3=2;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // Asp.g:656:3: (a2_0= parse_ASP_Rule )
            	    {
            	    // Asp.g:656:3: (a2_0= parse_ASP_Rule )
            	    // Asp.g:657:4: a2_0= parse_ASP_Rule
            	    {
            	    pushFollow(FOLLOW_parse_ASP_Rule_in_parse_ASP_Transformation194);
            	    a2_0=parse_ASP_Rule();

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
            	    						addObjectToList(element, ASP.ASPPackage.TRANSFORMATION__RULES, value);
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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[32]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[33]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[34]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[35]);
            	}

            // Asp.g:686:2: ( (a3_0= parse_ASP_Constraint ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==TEXT||LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Asp.g:687:3: (a3_0= parse_ASP_Constraint )
            	    {
            	    // Asp.g:687:3: (a3_0= parse_ASP_Constraint )
            	    // Asp.g:688:4: a3_0= parse_ASP_Constraint
            	    {
            	    pushFollow(FOLLOW_parse_ASP_Constraint_in_parse_ASP_Transformation229);
            	    a3_0=parse_ASP_Constraint();

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
            	    				if (a3_0 != null) {
            	    					if (a3_0 != null) {
            	    						Object value = a3_0;
            	    						addObjectToList(element, ASP.ASPPackage.TRANSFORMATION__CONSTRAINTS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_0_0_0_6, a3_0, true);
            	    					copyLocalizationInfos(a3_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[36]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[37]);
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
    // Asp.g:717:1: parse_ASP_Relation returns [ASP.Relation element = null] : (a0_0= parse_ASP_Pattern ) (a1_0= parse_ASP_RightPattern ) ;
    public final ASP.Relation parse_ASP_Relation() throws RecognitionException {
        ASP.Relation element =  null;

        int parse_ASP_Relation_StartIndex = input.index();

        ASP.Pattern a0_0 =null;

        ASP.RightPattern a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Asp.g:720:2: ( (a0_0= parse_ASP_Pattern ) (a1_0= parse_ASP_RightPattern ) )
            // Asp.g:721:2: (a0_0= parse_ASP_Pattern ) (a1_0= parse_ASP_RightPattern )
            {
            // Asp.g:721:2: (a0_0= parse_ASP_Pattern )
            // Asp.g:722:3: a0_0= parse_ASP_Pattern
            {
            pushFollow(FOLLOW_parse_ASP_Pattern_in_parse_ASP_Relation274);
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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getRelation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[38]);
            	}

            // Asp.g:747:2: (a1_0= parse_ASP_RightPattern )
            // Asp.g:748:3: a1_0= parse_ASP_RightPattern
            {
            pushFollow(FOLLOW_parse_ASP_RightPattern_in_parse_ASP_Relation296);
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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[39]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[40]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[41]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[42]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[43]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[44]);
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
    // Asp.g:780:1: parse_ASP_LeftPattern returns [ASP.LeftPattern element = null] : ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) ) (a5= QUOTED_40_41 ) a6= '.' ;
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

            // Asp.g:783:2: ( ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) ) (a5= QUOTED_40_41 ) a6= '.' )
            // Asp.g:784:2: ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) ) (a5= QUOTED_40_41 ) a6= '.'
            {
            // Asp.g:784:2: ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) )
            // Asp.g:785:3: (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' )
            {
            // Asp.g:785:3: (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt5=1;
                }
                break;
            case 31:
                {
                alt5=2;
                }
                break;
            case 29:
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
                    // Asp.g:786:4: a0= 'relation_node'
                    {
                    a0=(Token)match(input,30,FOLLOW_30_in_parse_ASP_LeftPattern338); if (state.failed) return element;

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
                    // Asp.g:799:8: a1= 'relation_prop'
                    {
                    a1=(Token)match(input,31,FOLLOW_31_in_parse_ASP_LeftPattern353); if (state.failed) return element;

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
                    // Asp.g:812:8: a2= 'relation_edge'
                    {
                    a2=(Token)match(input,29,FOLLOW_29_in_parse_ASP_LeftPattern368); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[45]);
            	}

            // Asp.g:832:2: (a5= QUOTED_40_41 )
            // Asp.g:833:3: a5= QUOTED_40_41
            {
            a5=(Token)match(input,QUOTED_40_41,FOLLOW_QUOTED_40_41_in_parse_ASP_LeftPattern393); if (state.failed) return element;

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
            				ASP.Function proxy = ASP.ASPFactory.eINSTANCE.createNamedFunction();
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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[46]);
            	}

            a6=(Token)match(input,15,FOLLOW_15_in_parse_ASP_LeftPattern414); if (state.failed) return element;

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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getRelation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[47]);
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
    // Asp.g:888:1: parse_ASP_RightPattern returns [ASP.RightPattern element = null] : ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) ) (a5= QUOTED_40_41 ) a6= '.' ;
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

            // Asp.g:891:2: ( ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) ) (a5= QUOTED_40_41 ) a6= '.' )
            // Asp.g:892:2: ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) ) (a5= QUOTED_40_41 ) a6= '.'
            {
            // Asp.g:892:2: ( (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' ) )
            // Asp.g:893:3: (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' )
            {
            // Asp.g:893:3: (a0= 'relation_node' |a1= 'relation_prop' |a2= 'relation_edge' )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt6=1;
                }
                break;
            case 31:
                {
                alt6=2;
                }
                break;
            case 29:
                {
                alt6=3;
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
                    // Asp.g:894:4: a0= 'relation_node'
                    {
                    a0=(Token)match(input,30,FOLLOW_30_in_parse_ASP_RightPattern452); if (state.failed) return element;

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
                    // Asp.g:907:8: a1= 'relation_prop'
                    {
                    a1=(Token)match(input,31,FOLLOW_31_in_parse_ASP_RightPattern467); if (state.failed) return element;

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
                    // Asp.g:920:8: a2= 'relation_edge'
                    {
                    a2=(Token)match(input,29,FOLLOW_29_in_parse_ASP_RightPattern482); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[48]);
            	}

            // Asp.g:940:2: (a5= QUOTED_40_41 )
            // Asp.g:941:3: a5= QUOTED_40_41
            {
            a5=(Token)match(input,QUOTED_40_41,FOLLOW_QUOTED_40_41_in_parse_ASP_RightPattern507); if (state.failed) return element;

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
            				ASP.Function proxy = ASP.ASPFactory.eINSTANCE.createNamedFunction();
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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[49]);
            	}

            a6=(Token)match(input,15,FOLLOW_15_in_parse_ASP_RightPattern528); if (state.failed) return element;

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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getRelation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[50]);
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
    // Asp.g:996:1: parse_ASP_Metanode returns [ASP.Metanode element = null] : a0= 'metanode(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ').' ;
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

            // Asp.g:999:2: (a0= 'metanode(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ').' )
            // Asp.g:1000:2: a0= 'metanode(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ').'
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_ASP_Metanode557); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[51]);
            	}

            // Asp.g:1014:2: (a1= TEXT )
            // Asp.g:1015:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metanode575); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[52]);
            	}

            a2=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Metanode596); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[53]);
            	}

            // Asp.g:1068:2: (a3= TEXT )
            // Asp.g:1069:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metanode614); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[54]);
            	}

            a4=(Token)match(input,13,FOLLOW_13_in_parse_ASP_Metanode635); if (state.failed) return element;

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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[55]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[56]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[57]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[58]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[59]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[60]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[61]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[62]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[63]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[64]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[65]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[66]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[67]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[68]);
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
    // Asp.g:1137:1: parse_ASP_Metaprop returns [ASP.Metaprop element = null] : a0= 'metaprop(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ').' ;
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

            // Asp.g:1140:2: (a0= 'metaprop(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ').' )
            // Asp.g:1141:2: a0= 'metaprop(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ').'
            {
            a0=(Token)match(input,22,FOLLOW_22_in_parse_ASP_Metaprop664); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[69]);
            	}

            // Asp.g:1155:2: (a1= TEXT )
            // Asp.g:1156:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metaprop682); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[70]);
            	}

            a2=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Metaprop703); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[71]);
            	}

            // Asp.g:1209:2: (a3= TEXT )
            // Asp.g:1210:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metaprop721); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[72]);
            	}

            a4=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Metaprop742); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[73]);
            	}

            // Asp.g:1263:2: (a5= TEXT )
            // Asp.g:1264:3: a5= TEXT
            {
            a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metaprop760); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[74]);
            	}

            a6=(Token)match(input,13,FOLLOW_13_in_parse_ASP_Metaprop781); if (state.failed) return element;

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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[75]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[76]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[77]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[78]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[79]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[80]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[81]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[82]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[83]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[84]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[85]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[86]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[87]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[88]);
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
    // Asp.g:1332:1: parse_ASP_Metaedge returns [ASP.Metaedge element = null] : a0= 'metaedge(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ').' ;
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

            // Asp.g:1335:2: (a0= 'metaedge(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ').' )
            // Asp.g:1336:2: a0= 'metaedge(' (a1= TEXT ) a2= ',' (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ').'
            {
            a0=(Token)match(input,20,FOLLOW_20_in_parse_ASP_Metaedge810); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[89]);
            	}

            // Asp.g:1350:2: (a1= TEXT )
            // Asp.g:1351:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metaedge828); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[90]);
            	}

            a2=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Metaedge849); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[91]);
            	}

            // Asp.g:1404:2: (a3= TEXT )
            // Asp.g:1405:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metaedge867); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[92]);
            	}

            a4=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Metaedge888); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[93]);
            	}

            // Asp.g:1458:2: (a5= TEXT )
            // Asp.g:1459:3: a5= TEXT
            {
            a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metaedge906); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[94]);
            	}

            a6=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Metaedge927); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[95]);
            	}

            // Asp.g:1512:2: (a7= TEXT )
            // Asp.g:1513:3: a7= TEXT
            {
            a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Metaedge945); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[96]);
            	}

            a8=(Token)match(input,13,FOLLOW_13_in_parse_ASP_Metaedge966); if (state.failed) return element;

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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[97]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[98]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[99]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[100]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[101]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[102]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[103]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[104]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[105]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[106]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[107]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[108]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[109]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[110]);
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
    // Asp.g:1581:1: parse_ASP_Node returns [ASP.Node element = null] : ( (a0= 'nodex(' |a1= 'node(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ').' ;
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

            // Asp.g:1584:2: ( ( (a0= 'nodex(' |a1= 'node(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ').' )
            // Asp.g:1585:2: ( (a0= 'nodex(' |a1= 'node(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ').'
            {
            // Asp.g:1585:2: ( (a0= 'nodex(' |a1= 'node(' ) )
            // Asp.g:1586:3: (a0= 'nodex(' |a1= 'node(' )
            {
            // Asp.g:1586:3: (a0= 'nodex(' |a1= 'node(' )
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
                    // Asp.g:1587:4: a0= 'nodex('
                    {
                    a0=(Token)match(input,25,FOLLOW_25_in_parse_ASP_Node1004); if (state.failed) return element;

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
                    // Asp.g:1600:8: a1= 'node('
                    {
                    a1=(Token)match(input,24,FOLLOW_24_in_parse_ASP_Node1019); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[111]);
            	}

            // Asp.g:1620:2: (a3= TEXT )
            // Asp.g:1621:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Node1044); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[112]);
            	}

            a4=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Node1065); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[113]);
            	}

            // Asp.g:1674:2: (a5= TEXT )
            // Asp.g:1675:3: a5= TEXT
            {
            a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Node1083); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[114]);
            	}

            a6=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Node1104); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[115]);
            	}

            // Asp.g:1728:2: (a7= TEXT )
            // Asp.g:1729:3: a7= TEXT
            {
            a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Node1122); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[116]);
            	}

            a8=(Token)match(input,13,FOLLOW_13_in_parse_ASP_Node1143); if (state.failed) return element;

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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[117]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[118]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[119]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[120]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[121]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[122]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[123]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[124]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[125]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[126]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[127]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[128]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[129]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[130]);
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
    // Asp.g:1797:1: parse_ASP_Prop returns [ASP.Prop element = null] : ( (a0= 'propx(' |a1= 'prop(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ',' (a9= TEXT ) a10= ').' ;
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

            // Asp.g:1800:2: ( ( (a0= 'propx(' |a1= 'prop(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ',' (a9= TEXT ) a10= ').' )
            // Asp.g:1801:2: ( (a0= 'propx(' |a1= 'prop(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ',' (a9= TEXT ) a10= ').'
            {
            // Asp.g:1801:2: ( (a0= 'propx(' |a1= 'prop(' ) )
            // Asp.g:1802:3: (a0= 'propx(' |a1= 'prop(' )
            {
            // Asp.g:1802:3: (a0= 'propx(' |a1= 'prop(' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==28) ) {
                alt8=1;
            }
            else if ( (LA8_0==27) ) {
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
                    // Asp.g:1803:4: a0= 'propx('
                    {
                    a0=(Token)match(input,28,FOLLOW_28_in_parse_ASP_Prop1181); if (state.failed) return element;

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
                    // Asp.g:1816:8: a1= 'prop('
                    {
                    a1=(Token)match(input,27,FOLLOW_27_in_parse_ASP_Prop1196); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[131]);
            	}

            // Asp.g:1836:2: (a3= TEXT )
            // Asp.g:1837:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Prop1221); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[132]);
            	}

            a4=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Prop1242); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[133]);
            	}

            // Asp.g:1890:2: (a5= TEXT )
            // Asp.g:1891:3: a5= TEXT
            {
            a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Prop1260); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[134]);
            	}

            a6=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Prop1281); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[135]);
            	}

            // Asp.g:1944:2: (a7= TEXT )
            // Asp.g:1945:3: a7= TEXT
            {
            a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Prop1299); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[136]);
            	}

            a8=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Prop1320); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[137]);
            	}

            // Asp.g:1998:2: (a9= TEXT )
            // Asp.g:1999:3: a9= TEXT
            {
            a9=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Prop1338); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[138]);
            	}

            a10=(Token)match(input,13,FOLLOW_13_in_parse_ASP_Prop1359); if (state.failed) return element;

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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[139]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[140]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[141]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[142]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[143]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[144]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[145]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[146]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[147]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[148]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[149]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[150]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[151]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[152]);
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
    // Asp.g:2067:1: parse_ASP_Edge returns [ASP.Edge element = null] : ( (a0= 'edgex(' |a1= 'edge(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ',' (a9= TEXT ) a10= ',' (a11= TEXT ) a12= ').' ;
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

            // Asp.g:2070:2: ( ( (a0= 'edgex(' |a1= 'edge(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ',' (a9= TEXT ) a10= ',' (a11= TEXT ) a12= ').' )
            // Asp.g:2071:2: ( (a0= 'edgex(' |a1= 'edge(' ) ) (a3= TEXT ) a4= ',' (a5= TEXT ) a6= ',' (a7= TEXT ) a8= ',' (a9= TEXT ) a10= ',' (a11= TEXT ) a12= ').'
            {
            // Asp.g:2071:2: ( (a0= 'edgex(' |a1= 'edge(' ) )
            // Asp.g:2072:3: (a0= 'edgex(' |a1= 'edge(' )
            {
            // Asp.g:2072:3: (a0= 'edgex(' |a1= 'edge(' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            else if ( (LA9_0==18) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // Asp.g:2073:4: a0= 'edgex('
                    {
                    a0=(Token)match(input,19,FOLLOW_19_in_parse_ASP_Edge1397); if (state.failed) return element;

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
                    // Asp.g:2086:8: a1= 'edge('
                    {
                    a1=(Token)match(input,18,FOLLOW_18_in_parse_ASP_Edge1412); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[153]);
            	}

            // Asp.g:2106:2: (a3= TEXT )
            // Asp.g:2107:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Edge1437); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[154]);
            	}

            a4=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Edge1458); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[155]);
            	}

            // Asp.g:2160:2: (a5= TEXT )
            // Asp.g:2161:3: a5= TEXT
            {
            a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Edge1476); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[156]);
            	}

            a6=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Edge1497); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[157]);
            	}

            // Asp.g:2214:2: (a7= TEXT )
            // Asp.g:2215:3: a7= TEXT
            {
            a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Edge1515); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[158]);
            	}

            a8=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Edge1536); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[159]);
            	}

            // Asp.g:2268:2: (a9= TEXT )
            // Asp.g:2269:3: a9= TEXT
            {
            a9=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Edge1554); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[160]);
            	}

            a10=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Edge1575); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[161]);
            	}

            // Asp.g:2322:2: (a11= TEXT )
            // Asp.g:2323:3: a11= TEXT
            {
            a11=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Edge1593); if (state.failed) return element;

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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[162]);
            	}

            a12=(Token)match(input,13,FOLLOW_13_in_parse_ASP_Edge1614); if (state.failed) return element;

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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[163]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[164]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[165]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[166]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[167]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[168]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[169]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[170]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[171]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[172]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[173]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[174]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[175]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[176]);
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



    // $ANTLR start "parse_ASP_NamedFunction"
    // Asp.g:2391:1: parse_ASP_NamedFunction returns [ASP.NamedFunction element = null] : (a0= TEXT ) a1= '(' (a2= TEXT ) ( (a3= ',' (a4= TEXT ) ) )* a5= ')' ;
    public final ASP.NamedFunction parse_ASP_NamedFunction() throws RecognitionException {
        ASP.NamedFunction element =  null;

        int parse_ASP_NamedFunction_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Asp.g:2394:2: ( (a0= TEXT ) a1= '(' (a2= TEXT ) ( (a3= ',' (a4= TEXT ) ) )* a5= ')' )
            // Asp.g:2395:2: (a0= TEXT ) a1= '(' (a2= TEXT ) ( (a3= ',' (a4= TEXT ) ) )* a5= ')'
            {
            // Asp.g:2395:2: (a0= TEXT )
            // Asp.g:2396:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_NamedFunction1647); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createNamedFunction();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[177]);
            	}

            a1=(Token)match(input,11,FOLLOW_11_in_parse_ASP_NamedFunction1668); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createNamedFunction();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[178]);
            	}

            // Asp.g:2445:2: (a2= TEXT )
            // Asp.g:2446:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_NamedFunction1686); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createNamedFunction();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__LITERALS), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__LITERALS), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					addObjectToList(element, ASP.ASPPackage.NAMED_FUNCTION__LITERALS, value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_4, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[179]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[180]);
            	}

            // Asp.g:2486:2: ( (a3= ',' (a4= TEXT ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==14) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Asp.g:2487:3: (a3= ',' (a4= TEXT ) )
            	    {
            	    // Asp.g:2487:3: (a3= ',' (a4= TEXT ) )
            	    // Asp.g:2488:4: a3= ',' (a4= TEXT )
            	    {
            	    a3=(Token)match(input,14,FOLLOW_14_in_parse_ASP_NamedFunction1716); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = ASP.ASPFactory.eINSTANCE.createNamedFunction();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_5_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[181]);
            	    			}

            	    // Asp.g:2502:4: (a4= TEXT )
            	    // Asp.g:2503:5: a4= TEXT
            	    {
            	    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_NamedFunction1742); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = ASP.ASPFactory.eINSTANCE.createNamedFunction();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a4 != null) {
            	    						ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	    						tokenResolver.setOptions(getOptions());
            	    						ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
            	    						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__LITERALS), result);
            	    						Object resolvedObject = result.getResolvedToken();
            	    						if (resolvedObject == null) {
            	    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            	    						}
            	    						String resolved = (String) resolvedObject;
            	    						ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
            	    						collectHiddenTokens(element);
            	    						registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Function, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__LITERALS), resolved, proxy);
            	    						if (proxy != null) {
            	    							Object value = proxy;
            	    							addObjectToList(element, ASP.ASPPackage.NAMED_FUNCTION__LITERALS, value);
            	    							completedElement(value, false);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_5_0_0_2, proxy, true);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[182]);
            	    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[183]);
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
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[184]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[185]);
            	}

            a5=(Token)match(input,12,FOLLOW_12_in_parse_ASP_NamedFunction1788); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createNamedFunction();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[186]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[187]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[188]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[189]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[190]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[191]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[192]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[193]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[194]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[195]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[196]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[197]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[198]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[199]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, parse_ASP_NamedFunction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_NamedFunction"



    // $ANTLR start "parse_ASP_Rule"
    // Asp.g:2580:1: parse_ASP_Rule returns [ASP.Rule element = null] : ( ( (a0= TEXT ) ) )? (a1_0= parse_ASP_Terminal ) a2= ':-' (a3_0= parse_ASP_Expression ) ( (a4= ',' (a5_0= parse_ASP_Expression ) ) )* ( (a6= ',' a7= 'mmt=' (a8= TEXT ) ) )? a9= '.' ;
    public final ASP.Rule parse_ASP_Rule() throws RecognitionException {
        ASP.Rule element =  null;

        int parse_ASP_Rule_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        ASP.Terminal a1_0 =null;

        ASP.Expression a3_0 =null;

        ASP.Expression a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Asp.g:2583:2: ( ( ( (a0= TEXT ) ) )? (a1_0= parse_ASP_Terminal ) a2= ':-' (a3_0= parse_ASP_Expression ) ( (a4= ',' (a5_0= parse_ASP_Expression ) ) )* ( (a6= ',' a7= 'mmt=' (a8= TEXT ) ) )? a9= '.' )
            // Asp.g:2584:2: ( ( (a0= TEXT ) ) )? (a1_0= parse_ASP_Terminal ) a2= ':-' (a3_0= parse_ASP_Expression ) ( (a4= ',' (a5_0= parse_ASP_Expression ) ) )* ( (a6= ',' a7= 'mmt=' (a8= TEXT ) ) )? a9= '.'
            {
            // Asp.g:2584:2: ( ( (a0= TEXT ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==TEXT) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==TEXT) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // Asp.g:2585:3: ( (a0= TEXT ) )
                    {
                    // Asp.g:2585:3: ( (a0= TEXT ) )
                    // Asp.g:2586:4: (a0= TEXT )
                    {
                    // Asp.g:2586:4: (a0= TEXT )
                    // Asp.g:2587:5: a0= TEXT
                    {
                    a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Rule1832); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new ASP.resource.asp.mopp.AspTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = ASP.ASPFactory.eINSTANCE.createRule();
                    						startIncompleteElement(element);
                    					}
                    					if (a0 != null) {
                    						ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    						tokenResolver.setOptions(getOptions());
                    						ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
                    						tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__COMMENT), result);
                    						Object resolvedObject = result.getResolvedToken();
                    						if (resolvedObject == null) {
                    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
                    						}
                    						java.lang.String resolved = (java.lang.String) resolvedObject;
                    						if (resolved != null) {
                    							Object value = resolved;
                    							element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__COMMENT), value);
                    							completedElement(value, false);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_11_0_0_0_0_0_0, resolved, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getRule(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[200]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getRule(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[201]);
            	}

            // Asp.g:2629:2: (a1_0= parse_ASP_Terminal )
            // Asp.g:2630:3: a1_0= parse_ASP_Terminal
            {
            pushFollow(FOLLOW_parse_ASP_Terminal_in_parse_ASP_Rule1882);
            a1_0=parse_ASP_Terminal();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createRule();
            				startIncompleteElement(element);
            			}
            			if (a1_0 != null) {
            				if (a1_0 != null) {
            					Object value = a1_0;
            					element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__HEAD), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_11_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[202]);
            	}

            a2=(Token)match(input,16,FOLLOW_16_in_parse_ASP_Rule1900); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createRule();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_11_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getRule(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[203]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getRule(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[204]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getRule(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[205]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getRule(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[206]);
            	}

            // Asp.g:2672:2: (a3_0= parse_ASP_Expression )
            // Asp.g:2673:3: a3_0= parse_ASP_Expression
            {
            pushFollow(FOLLOW_parse_ASP_Expression_in_parse_ASP_Rule1918);
            a3_0=parse_ASP_Expression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            			}
            			if (element == null) {
            				element = ASP.ASPFactory.eINSTANCE.createRule();
            				startIncompleteElement(element);
            			}
            			if (a3_0 != null) {
            				if (a3_0 != null) {
            					Object value = a3_0;
            					addObjectToList(element, ASP.ASPPackage.RULE__EXPRESSIONS, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_11_0_0_5, a3_0, true);
            				copyLocalizationInfos(a3_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[207]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[208]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[209]);
            	}

            // Asp.g:2700:2: ( (a4= ',' (a5_0= parse_ASP_Expression ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==14) ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1==TEXT||LA12_1==26) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // Asp.g:2701:3: (a4= ',' (a5_0= parse_ASP_Expression ) )
            	    {
            	    // Asp.g:2701:3: (a4= ',' (a5_0= parse_ASP_Expression ) )
            	    // Asp.g:2702:4: a4= ',' (a5_0= parse_ASP_Expression )
            	    {
            	    a4=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Rule1945); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = ASP.ASPFactory.eINSTANCE.createRule();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_11_0_0_6_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getRule(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[210]);
            	    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getRule(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[211]);
            	    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getRule(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[212]);
            	    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getRule(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[213]);
            	    			}

            	    // Asp.g:2719:4: (a5_0= parse_ASP_Expression )
            	    // Asp.g:2720:5: a5_0= parse_ASP_Expression
            	    {
            	    pushFollow(FOLLOW_parse_ASP_Expression_in_parse_ASP_Rule1971);
            	    a5_0=parse_ASP_Expression();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new ASP.resource.asp.mopp.AspTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = ASP.ASPFactory.eINSTANCE.createRule();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a5_0 != null) {
            	    						if (a5_0 != null) {
            	    							Object value = a5_0;
            	    							addObjectToList(element, ASP.ASPPackage.RULE__EXPRESSIONS, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_11_0_0_6_0_0_2, a5_0, true);
            	    						copyLocalizationInfos(a5_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[214]);
            	    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[215]);
            	    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[216]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[217]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[218]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[219]);
            	}

            // Asp.g:2756:2: ( (a6= ',' a7= 'mmt=' (a8= TEXT ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==14) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Asp.g:2757:3: (a6= ',' a7= 'mmt=' (a8= TEXT ) )
                    {
                    // Asp.g:2757:3: (a6= ',' a7= 'mmt=' (a8= TEXT ) )
                    // Asp.g:2758:4: a6= ',' a7= 'mmt=' (a8= TEXT )
                    {
                    a6=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Rule2021); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createRule();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_11_0_0_8_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[220]);
                    			}

                    a7=(Token)match(input,23,FOLLOW_23_in_parse_ASP_Rule2041); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createRule();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_11_0_0_8_0_0_2, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[221]);
                    			}

                    // Asp.g:2786:4: (a8= TEXT )
                    // Asp.g:2787:5: a8= TEXT
                    {
                    a8=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Rule2067); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new ASP.resource.asp.mopp.AspTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = ASP.ASPFactory.eINSTANCE.createRule();
                    						startIncompleteElement(element);
                    					}
                    					if (a8 != null) {
                    						ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    						tokenResolver.setOptions(getOptions());
                    						ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
                    						tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__DIRECTION), result);
                    						Object resolvedObject = result.getResolvedToken();
                    						if (resolvedObject == null) {
                    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
                    						}
                    						String resolved = (String) resolvedObject;
                    						ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
                    						collectHiddenTokens(element);
                    						registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Rule, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRuleDirectionReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__DIRECTION), resolved, proxy);
                    						if (proxy != null) {
                    							Object value = proxy;
                    							element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__DIRECTION), value);
                    							completedElement(value, false);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_11_0_0_8_0_0_4, proxy, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, proxy);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[222]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[223]);
            	}

            a9=(Token)match(input,15,FOLLOW_15_in_parse_ASP_Rule2113); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createRule();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_11_0_0_10, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[224]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[225]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[226]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[227]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, parse_ASP_Rule_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Rule"



    // $ANTLR start "parse_ASP_Constraint"
    // Asp.g:2852:1: parse_ASP_Constraint returns [ASP.Constraint element = null] : ( ( (a0= TEXT ) ) )? a1= ':-' (a2_0= parse_ASP_Expression ) ( (a3= ',' (a4_0= parse_ASP_Expression ) ) )* ( (a5= ',' a6= 'mmt=' (a7= TEXT ) ) )? a8= '.' ;
    public final ASP.Constraint parse_ASP_Constraint() throws RecognitionException {
        ASP.Constraint element =  null;

        int parse_ASP_Constraint_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        ASP.Expression a2_0 =null;

        ASP.Expression a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Asp.g:2855:2: ( ( ( (a0= TEXT ) ) )? a1= ':-' (a2_0= parse_ASP_Expression ) ( (a3= ',' (a4_0= parse_ASP_Expression ) ) )* ( (a5= ',' a6= 'mmt=' (a7= TEXT ) ) )? a8= '.' )
            // Asp.g:2856:2: ( ( (a0= TEXT ) ) )? a1= ':-' (a2_0= parse_ASP_Expression ) ( (a3= ',' (a4_0= parse_ASP_Expression ) ) )* ( (a5= ',' a6= 'mmt=' (a7= TEXT ) ) )? a8= '.'
            {
            // Asp.g:2856:2: ( ( (a0= TEXT ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==TEXT) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Asp.g:2857:3: ( (a0= TEXT ) )
                    {
                    // Asp.g:2857:3: ( (a0= TEXT ) )
                    // Asp.g:2858:4: (a0= TEXT )
                    {
                    // Asp.g:2858:4: (a0= TEXT )
                    // Asp.g:2859:5: a0= TEXT
                    {
                    a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Constraint2157); if (state.failed) return element;

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
                    						retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_12_0_0_0_0_0_0, resolved, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[228]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[229]);
            	}

            a1=(Token)match(input,16,FOLLOW_16_in_parse_ASP_Constraint2203); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createConstraint();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_12_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[230]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[231]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[232]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[233]);
            	}

            // Asp.g:2918:2: (a2_0= parse_ASP_Expression )
            // Asp.g:2919:3: a2_0= parse_ASP_Expression
            {
            pushFollow(FOLLOW_parse_ASP_Expression_in_parse_ASP_Constraint2221);
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
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_12_0_0_3, a2_0, true);
            				copyLocalizationInfos(a2_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[234]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[235]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[236]);
            	}

            // Asp.g:2946:2: ( (a3= ',' (a4_0= parse_ASP_Expression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==14) ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1==TEXT||LA15_1==26) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // Asp.g:2947:3: (a3= ',' (a4_0= parse_ASP_Expression ) )
            	    {
            	    // Asp.g:2947:3: (a3= ',' (a4_0= parse_ASP_Expression ) )
            	    // Asp.g:2948:4: a3= ',' (a4_0= parse_ASP_Expression )
            	    {
            	    a3=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Constraint2248); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = ASP.ASPFactory.eINSTANCE.createConstraint();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_12_0_0_4_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[237]);
            	    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[238]);
            	    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[239]);
            	    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[240]);
            	    			}

            	    // Asp.g:2965:4: (a4_0= parse_ASP_Expression )
            	    // Asp.g:2966:5: a4_0= parse_ASP_Expression
            	    {
            	    pushFollow(FOLLOW_parse_ASP_Expression_in_parse_ASP_Constraint2274);
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
            	    						retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_12_0_0_4_0_0_2, a4_0, true);
            	    						copyLocalizationInfos(a4_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[241]);
            	    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[242]);
            	    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[243]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[244]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[245]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[246]);
            	}

            // Asp.g:3002:2: ( (a5= ',' a6= 'mmt=' (a7= TEXT ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Asp.g:3003:3: (a5= ',' a6= 'mmt=' (a7= TEXT ) )
                    {
                    // Asp.g:3003:3: (a5= ',' a6= 'mmt=' (a7= TEXT ) )
                    // Asp.g:3004:4: a5= ',' a6= 'mmt=' (a7= TEXT )
                    {
                    a5=(Token)match(input,14,FOLLOW_14_in_parse_ASP_Constraint2324); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createConstraint();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_12_0_0_6_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[247]);
                    			}

                    a6=(Token)match(input,23,FOLLOW_23_in_parse_ASP_Constraint2344); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createConstraint();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_12_0_0_6_0_0_2, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[248]);
                    			}

                    // Asp.g:3032:4: (a7= TEXT )
                    // Asp.g:3033:5: a7= TEXT
                    {
                    a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Constraint2370); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new ASP.resource.asp.mopp.AspTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = ASP.ASPFactory.eINSTANCE.createConstraint();
                    						startIncompleteElement(element);
                    					}
                    					if (a7 != null) {
                    						ASP.resource.asp.IAspTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    						tokenResolver.setOptions(getOptions());
                    						ASP.resource.asp.IAspTokenResolveResult result = getFreshTokenResolveResult();
                    						tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__DIRECTION), result);
                    						Object resolvedObject = result.getResolvedToken();
                    						if (resolvedObject == null) {
                    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
                    						}
                    						String resolved = (String) resolvedObject;
                    						ASP.Literal proxy = ASP.ASPFactory.eINSTANCE.createLiteral();
                    						collectHiddenTokens(element);
                    						registerContextDependentProxy(new ASP.resource.asp.mopp.AspContextDependentURIFragmentFactory<ASP.Constraint, ASP.Literal>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConstraintDirectionReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__DIRECTION), resolved, proxy);
                    						if (proxy != null) {
                    							Object value = proxy;
                    							element.eSet(element.eClass().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__DIRECTION), value);
                    							completedElement(value, false);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_12_0_0_6_0_0_4, proxy, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, proxy);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[249]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[250]);
            	}

            a8=(Token)match(input,15,FOLLOW_15_in_parse_ASP_Constraint2416); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createConstraint();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_12_0_0_8, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[251]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[252]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, parse_ASP_Constraint_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Constraint"



    // $ANTLR start "parse_ASP_Literal"
    // Asp.g:3096:1: parse_ASP_Literal returns [ASP.Literal element = null] : (a0= TEXT ) ( (a1= '.' ) )? ;
    public final ASP.Literal parse_ASP_Literal() throws RecognitionException {
        ASP.Literal element =  null;

        int parse_ASP_Literal_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Asp.g:3099:2: ( (a0= TEXT ) ( (a1= '.' ) )? )
            // Asp.g:3100:2: (a0= TEXT ) ( (a1= '.' ) )?
            {
            // Asp.g:3100:2: (a0= TEXT )
            // Asp.g:3101:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Literal2449); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_13_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[253]);
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
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[265]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[266]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[267]);
            	}

            // Asp.g:3150:2: ( (a1= '.' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==15) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // Asp.g:3151:3: (a1= '.' )
                    {
                    // Asp.g:3151:3: (a1= '.' )
                    // Asp.g:3152:4: a1= '.'
                    {
                    a1=(Token)match(input,15,FOLLOW_15_in_parse_ASP_Literal2479); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = ASP.ASPFactory.eINSTANCE.createLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_13_0_0_1_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[268]);
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
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[282]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[283]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[284]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[285]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[286]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[287]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[288]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[289]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[290]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[291]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[292]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[293]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[294]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[295]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, parse_ASP_Literal_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Literal"



    // $ANTLR start "parse_ASP_Terminal"
    // Asp.g:3201:1: parse_ASP_Terminal returns [ASP.Terminal element = null] : (a0= TEXT ) ;
    public final ASP.Terminal parse_ASP_Terminal() throws RecognitionException {
        ASP.Terminal element =  null;

        int parse_ASP_Terminal_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Asp.g:3204:2: ( (a0= TEXT ) )
            // Asp.g:3205:2: (a0= TEXT )
            {
            // Asp.g:3205:2: (a0= TEXT )
            // Asp.g:3206:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Terminal2531); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_14_0_0_0, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[296]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[297]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[298]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[299]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[300]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[301]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[302]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[303]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[304]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[305]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[306]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[307]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[308]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[309]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[310]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[311]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[312]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[313]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, parse_ASP_Terminal_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Terminal"



    // $ANTLR start "parse_ASP_Not"
    // Asp.g:3264:1: parse_ASP_Not returns [ASP.Not element = null] : a0= 'not' (a1= TEXT ) ;
    public final ASP.Not parse_ASP_Not() throws RecognitionException {
        ASP.Not element =  null;

        int parse_ASP_Not_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Asp.g:3267:2: (a0= 'not' (a1= TEXT ) )
            // Asp.g:3268:2: a0= 'not' (a1= TEXT )
            {
            a0=(Token)match(input,26,FOLLOW_26_in_parse_ASP_Not2567); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createNot();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_15_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[314]);
            	}

            // Asp.g:3282:2: (a1= TEXT )
            // Asp.g:3283:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Not2585); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_15_0_0_2, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[315]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[316]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[317]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[318]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[319]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[320]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[321]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[322]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[323]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[324]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[325]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[326]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[327]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[328]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[329]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[330]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[331]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[332]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[333]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[334]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, parse_ASP_Not_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Not"



    // $ANTLR start "parse_ASP_Eq"
    // Asp.g:3343:1: parse_ASP_Eq returns [ASP.Eq element = null] : (a0= TEXT ) a1= '==' (a2= TEXT ) ;
    public final ASP.Eq parse_ASP_Eq() throws RecognitionException {
        ASP.Eq element =  null;

        int parse_ASP_Eq_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Asp.g:3346:2: ( (a0= TEXT ) a1= '==' (a2= TEXT ) )
            // Asp.g:3347:2: (a0= TEXT ) a1= '==' (a2= TEXT )
            {
            // Asp.g:3347:2: (a0= TEXT )
            // Asp.g:3348:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Eq2625); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_16_0_0_0, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[335]);
            	}

            a1=(Token)match(input,17,FOLLOW_17_in_parse_ASP_Eq2646); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createEq();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_16_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[336]);
            	}

            // Asp.g:3401:2: (a2= TEXT )
            // Asp.g:3402:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_Eq2664); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_16_0_0_4, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[337]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[338]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[339]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[340]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[341]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[342]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[343]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[344]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[345]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[346]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[347]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[348]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[349]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[350]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[351]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[352]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[353]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[354]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[355]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[356]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, parse_ASP_Eq_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Eq"



    // $ANTLR start "parse_ASP_NotEq"
    // Asp.g:3462:1: parse_ASP_NotEq returns [ASP.NotEq element = null] : (a0= TEXT ) a1= '!=' (a2= TEXT ) ;
    public final ASP.NotEq parse_ASP_NotEq() throws RecognitionException {
        ASP.NotEq element =  null;

        int parse_ASP_NotEq_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Asp.g:3465:2: ( (a0= TEXT ) a1= '!=' (a2= TEXT ) )
            // Asp.g:3466:2: (a0= TEXT ) a1= '!=' (a2= TEXT )
            {
            // Asp.g:3466:2: (a0= TEXT )
            // Asp.g:3467:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_NotEq2704); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_17_0_0_0, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[357]);
            	}

            a1=(Token)match(input,10,FOLLOW_10_in_parse_ASP_NotEq2725); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = ASP.ASPFactory.eINSTANCE.createNotEq();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_17_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[358]);
            	}

            // Asp.g:3520:2: (a2= TEXT )
            // Asp.g:3521:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_ASP_NotEq2743); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_17_0_0_4, proxy, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[359]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[360]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[361]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[362]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[363]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[364]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[365]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[366]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[367]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[368]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[369]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[370]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[371]);
            		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[372]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[373]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[374]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[375]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[376]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[377]);
            		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[378]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, parse_ASP_NotEq_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_NotEq"



    // $ANTLR start "parse_ASP_Element"
    // Asp.g:3581:1: parse_ASP_Element returns [ASP.Element element = null] : (c0= parse_ASP_Metanode |c1= parse_ASP_Metaprop |c2= parse_ASP_Metaedge |c3= parse_ASP_Node |c4= parse_ASP_Prop |c5= parse_ASP_Edge |c6= parse_ASP_NamedFunction |c7= parse_ASP_Literal |c8= parse_ASP_Terminal |c9= parse_ASP_Not |c10= parse_ASP_Eq |c11= parse_ASP_NotEq );
    public final ASP.Element parse_ASP_Element() throws RecognitionException {
        ASP.Element element =  null;

        int parse_ASP_Element_StartIndex = input.index();

        ASP.Metanode c0 =null;

        ASP.Metaprop c1 =null;

        ASP.Metaedge c2 =null;

        ASP.Node c3 =null;

        ASP.Prop c4 =null;

        ASP.Edge c5 =null;

        ASP.NamedFunction c6 =null;

        ASP.Literal c7 =null;

        ASP.Terminal c8 =null;

        ASP.Not c9 =null;

        ASP.Eq c10 =null;

        ASP.NotEq c11 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Asp.g:3582:2: (c0= parse_ASP_Metanode |c1= parse_ASP_Metaprop |c2= parse_ASP_Metaedge |c3= parse_ASP_Node |c4= parse_ASP_Prop |c5= parse_ASP_Edge |c6= parse_ASP_NamedFunction |c7= parse_ASP_Literal |c8= parse_ASP_Terminal |c9= parse_ASP_Not |c10= parse_ASP_Eq |c11= parse_ASP_NotEq )
            int alt18=12;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt18=1;
                }
                break;
            case 22:
                {
                alt18=2;
                }
                break;
            case 20:
                {
                alt18=3;
                }
                break;
            case 24:
            case 25:
                {
                alt18=4;
                }
                break;
            case 27:
            case 28:
                {
                alt18=5;
                }
                break;
            case 18:
            case 19:
                {
                alt18=6;
                }
                break;
            case TEXT:
                {
                int LA18_7 = input.LA(2);

                if ( (LA18_7==11) ) {
                    alt18=7;
                }
                else if ( (LA18_7==17) ) {
                    alt18=11;
                }
                else if ( (LA18_7==10) ) {
                    alt18=12;
                }
                else if ( (synpred27_Asp()) ) {
                    alt18=8;
                }
                else if ( (synpred28_Asp()) ) {
                    alt18=9;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 7, input);

                    throw nvae;

                }
                }
                break;
            case 26:
                {
                alt18=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }

            switch (alt18) {
                case 1 :
                    // Asp.g:3583:2: c0= parse_ASP_Metanode
                    {
                    pushFollow(FOLLOW_parse_ASP_Metanode_in_parse_ASP_Element2775);
                    c0=parse_ASP_Metanode();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Asp.g:3584:4: c1= parse_ASP_Metaprop
                    {
                    pushFollow(FOLLOW_parse_ASP_Metaprop_in_parse_ASP_Element2785);
                    c1=parse_ASP_Metaprop();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Asp.g:3585:4: c2= parse_ASP_Metaedge
                    {
                    pushFollow(FOLLOW_parse_ASP_Metaedge_in_parse_ASP_Element2795);
                    c2=parse_ASP_Metaedge();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Asp.g:3586:4: c3= parse_ASP_Node
                    {
                    pushFollow(FOLLOW_parse_ASP_Node_in_parse_ASP_Element2805);
                    c3=parse_ASP_Node();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Asp.g:3587:4: c4= parse_ASP_Prop
                    {
                    pushFollow(FOLLOW_parse_ASP_Prop_in_parse_ASP_Element2815);
                    c4=parse_ASP_Prop();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Asp.g:3588:4: c5= parse_ASP_Edge
                    {
                    pushFollow(FOLLOW_parse_ASP_Edge_in_parse_ASP_Element2825);
                    c5=parse_ASP_Edge();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Asp.g:3589:4: c6= parse_ASP_NamedFunction
                    {
                    pushFollow(FOLLOW_parse_ASP_NamedFunction_in_parse_ASP_Element2835);
                    c6=parse_ASP_NamedFunction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Asp.g:3590:4: c7= parse_ASP_Literal
                    {
                    pushFollow(FOLLOW_parse_ASP_Literal_in_parse_ASP_Element2845);
                    c7=parse_ASP_Literal();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Asp.g:3591:4: c8= parse_ASP_Terminal
                    {
                    pushFollow(FOLLOW_parse_ASP_Terminal_in_parse_ASP_Element2855);
                    c8=parse_ASP_Terminal();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c8; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 10 :
                    // Asp.g:3592:4: c9= parse_ASP_Not
                    {
                    pushFollow(FOLLOW_parse_ASP_Not_in_parse_ASP_Element2865);
                    c9=parse_ASP_Not();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c9; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 11 :
                    // Asp.g:3593:4: c10= parse_ASP_Eq
                    {
                    pushFollow(FOLLOW_parse_ASP_Eq_in_parse_ASP_Element2875);
                    c10=parse_ASP_Eq();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c10; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 12 :
                    // Asp.g:3594:4: c11= parse_ASP_NotEq
                    {
                    pushFollow(FOLLOW_parse_ASP_NotEq_in_parse_ASP_Element2885);
                    c11=parse_ASP_NotEq();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c11; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 20, parse_ASP_Element_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Element"



    // $ANTLR start "parse_ASP_Pattern"
    // Asp.g:3598:1: parse_ASP_Pattern returns [ASP.Pattern element = null] : (c0= parse_ASP_LeftPattern |c1= parse_ASP_RightPattern );
    public final ASP.Pattern parse_ASP_Pattern() throws RecognitionException {
        ASP.Pattern element =  null;

        int parse_ASP_Pattern_StartIndex = input.index();

        ASP.LeftPattern c0 =null;

        ASP.RightPattern c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Asp.g:3599:2: (c0= parse_ASP_LeftPattern |c1= parse_ASP_RightPattern )
            int alt19=2;
            switch ( input.LA(1) ) {
            case 30:
                {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==QUOTED_40_41) ) {
                    int LA19_4 = input.LA(3);

                    if ( (LA19_4==15) ) {
                        int LA19_5 = input.LA(4);

                        if ( (synpred31_Asp()) ) {
                            alt19=1;
                        }
                        else if ( (true) ) {
                            alt19=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 19, 5, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 4, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;

                }
                }
                break;
            case 31:
                {
                int LA19_2 = input.LA(2);

                if ( (LA19_2==QUOTED_40_41) ) {
                    int LA19_4 = input.LA(3);

                    if ( (LA19_4==15) ) {
                        int LA19_5 = input.LA(4);

                        if ( (synpred31_Asp()) ) {
                            alt19=1;
                        }
                        else if ( (true) ) {
                            alt19=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 19, 5, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 4, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 2, input);

                    throw nvae;

                }
                }
                break;
            case 29:
                {
                int LA19_3 = input.LA(2);

                if ( (LA19_3==QUOTED_40_41) ) {
                    int LA19_4 = input.LA(3);

                    if ( (LA19_4==15) ) {
                        int LA19_5 = input.LA(4);

                        if ( (synpred31_Asp()) ) {
                            alt19=1;
                        }
                        else if ( (true) ) {
                            alt19=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 19, 5, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 4, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }

            switch (alt19) {
                case 1 :
                    // Asp.g:3600:2: c0= parse_ASP_LeftPattern
                    {
                    pushFollow(FOLLOW_parse_ASP_LeftPattern_in_parse_ASP_Pattern2906);
                    c0=parse_ASP_LeftPattern();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Asp.g:3601:4: c1= parse_ASP_RightPattern
                    {
                    pushFollow(FOLLOW_parse_ASP_RightPattern_in_parse_ASP_Pattern2916);
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
            if ( state.backtracking>0 ) { memoize(input, 21, parse_ASP_Pattern_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Pattern"



    // $ANTLR start "parse_ASP_Expression"
    // Asp.g:3605:1: parse_ASP_Expression returns [ASP.Expression element = null] : (c0= parse_ASP_Terminal |c1= parse_ASP_Not |c2= parse_ASP_Eq |c3= parse_ASP_NotEq );
    public final ASP.Expression parse_ASP_Expression() throws RecognitionException {
        ASP.Expression element =  null;

        int parse_ASP_Expression_StartIndex = input.index();

        ASP.Terminal c0 =null;

        ASP.Not c1 =null;

        ASP.Eq c2 =null;

        ASP.NotEq c3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Asp.g:3606:2: (c0= parse_ASP_Terminal |c1= parse_ASP_Not |c2= parse_ASP_Eq |c3= parse_ASP_NotEq )
            int alt20=4;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==TEXT) ) {
                switch ( input.LA(2) ) {
                case EOF:
                case 14:
                case 15:
                    {
                    alt20=1;
                    }
                    break;
                case 17:
                    {
                    alt20=3;
                    }
                    break;
                case 10:
                    {
                    alt20=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;

                }

            }
            else if ( (LA20_0==26) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // Asp.g:3607:2: c0= parse_ASP_Terminal
                    {
                    pushFollow(FOLLOW_parse_ASP_Terminal_in_parse_ASP_Expression2937);
                    c0=parse_ASP_Terminal();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Asp.g:3608:4: c1= parse_ASP_Not
                    {
                    pushFollow(FOLLOW_parse_ASP_Not_in_parse_ASP_Expression2947);
                    c1=parse_ASP_Not();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Asp.g:3609:4: c2= parse_ASP_Eq
                    {
                    pushFollow(FOLLOW_parse_ASP_Eq_in_parse_ASP_Expression2957);
                    c2=parse_ASP_Eq();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Asp.g:3610:4: c3= parse_ASP_NotEq
                    {
                    pushFollow(FOLLOW_parse_ASP_NotEq_in_parse_ASP_Expression2967);
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
            if ( state.backtracking>0 ) { memoize(input, 22, parse_ASP_Expression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_ASP_Expression"

    // $ANTLR start synpred3_Asp
    public final void synpred3_Asp_fragment() throws RecognitionException {
        ASP.Rule a2_0 =null;


        // Asp.g:656:3: ( (a2_0= parse_ASP_Rule ) )
        // Asp.g:656:3: (a2_0= parse_ASP_Rule )
        {
        // Asp.g:656:3: (a2_0= parse_ASP_Rule )
        // Asp.g:657:4: a2_0= parse_ASP_Rule
        {
        pushFollow(FOLLOW_parse_ASP_Rule_in_synpred3_Asp194);
        a2_0=parse_ASP_Rule();

        state._fsp--;
        if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred3_Asp

    // $ANTLR start synpred27_Asp
    public final void synpred27_Asp_fragment() throws RecognitionException {
        ASP.Literal c7 =null;


        // Asp.g:3590:4: (c7= parse_ASP_Literal )
        // Asp.g:3590:4: c7= parse_ASP_Literal
        {
        pushFollow(FOLLOW_parse_ASP_Literal_in_synpred27_Asp2845);
        c7=parse_ASP_Literal();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred27_Asp

    // $ANTLR start synpred28_Asp
    public final void synpred28_Asp_fragment() throws RecognitionException {
        ASP.Terminal c8 =null;


        // Asp.g:3591:4: (c8= parse_ASP_Terminal )
        // Asp.g:3591:4: c8= parse_ASP_Terminal
        {
        pushFollow(FOLLOW_parse_ASP_Terminal_in_synpred28_Asp2855);
        c8=parse_ASP_Terminal();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred28_Asp

    // $ANTLR start synpred31_Asp
    public final void synpred31_Asp_fragment() throws RecognitionException {
        ASP.LeftPattern c0 =null;


        // Asp.g:3600:2: (c0= parse_ASP_LeftPattern )
        // Asp.g:3600:2: c0= parse_ASP_LeftPattern
        {
        pushFollow(FOLLOW_parse_ASP_LeftPattern_in_synpred31_Asp2906);
        c0=parse_ASP_LeftPattern();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred31_Asp

    // Delegated rules

    public final boolean synpred28_Asp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_Asp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_Asp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_Asp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_Asp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_Asp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_Asp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_Asp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\37\uffff";
    static final String DFA3_eofS =
        "\1\2\36\uffff";
    static final String DFA3_minS =
        "\2\10\1\uffff\1\10\1\uffff\1\12\2\10\1\0\2\10\1\16\1\12\2\10\2\16"+
        "\2\0\2\10\1\16\1\17\2\0\2\16\4\0";
    static final String DFA3_maxS =
        "\2\20\1\uffff\1\32\1\uffff\1\21\1\10\1\32\1\0\2\10\1\17\1\21\2\10"+
        "\2\17\2\0\2\10\2\17\2\0\2\17\4\0";
    static final String DFA3_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\32\uffff";
    static final String DFA3_specialS =
        "\10\uffff\1\0\10\uffff\1\1\1\2\4\uffff\1\3\1\4\2\uffff\1\5\1\6\1"+
        "\7\1\10}>";
    static final String[] DFA3_transitionS = {
            "\1\1\7\uffff\1\2",
            "\1\4\7\uffff\1\3",
            "",
            "\1\5\21\uffff\1\6",
            "",
            "\1\12\3\uffff\1\7\1\10\1\uffff\1\11",
            "\1\13",
            "\1\14\16\uffff\1\16\2\uffff\1\15",
            "\1\uffff",
            "\1\17",
            "\1\20",
            "\1\7\1\21",
            "\1\24\3\uffff\1\7\1\22\1\uffff\1\23",
            "\1\25",
            "\1\26",
            "\1\7\1\27",
            "\1\7\1\30",
            "\1\uffff",
            "\1\uffff",
            "\1\31",
            "\1\32",
            "\1\7\1\33",
            "\1\34",
            "\1\uffff",
            "\1\uffff",
            "\1\7\1\35",
            "\1\7\1\36",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "()* loopback of 655:2: ( (a2_0= parse_ASP_Rule ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_8 = input.LA(1);

                         
                        int index3_8 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred3_Asp()) ) {s = 4;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index3_8);

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA3_17 = input.LA(1);

                         
                        int index3_17 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred3_Asp()) ) {s = 4;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index3_17);

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA3_18 = input.LA(1);

                         
                        int index3_18 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred3_Asp()) ) {s = 4;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index3_18);

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA3_23 = input.LA(1);

                         
                        int index3_23 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred3_Asp()) ) {s = 4;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index3_23);

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA3_24 = input.LA(1);

                         
                        int index3_24 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred3_Asp()) ) {s = 4;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index3_24);

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA3_27 = input.LA(1);

                         
                        int index3_27 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred3_Asp()) ) {s = 4;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index3_27);

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA3_28 = input.LA(1);

                         
                        int index3_28 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred3_Asp()) ) {s = 4;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index3_28);

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA3_29 = input.LA(1);

                         
                        int index3_29 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred3_Asp()) ) {s = 4;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index3_29);

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA3_30 = input.LA(1);

                         
                        int index3_30 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred3_Asp()) ) {s = 4;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index3_30);

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

    public static final BitSet FOLLOW_parse_ASP_Transformation_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Element_in_parse_ASP_Transformation124 = new BitSet(new long[]{0x00000000FF7C0100L});
    public static final BitSet FOLLOW_parse_ASP_Relation_in_parse_ASP_Transformation159 = new BitSet(new long[]{0x00000000E0010102L});
    public static final BitSet FOLLOW_parse_ASP_Rule_in_parse_ASP_Transformation194 = new BitSet(new long[]{0x0000000000010102L});
    public static final BitSet FOLLOW_parse_ASP_Constraint_in_parse_ASP_Transformation229 = new BitSet(new long[]{0x0000000000010102L});
    public static final BitSet FOLLOW_parse_ASP_Pattern_in_parse_ASP_Relation274 = new BitSet(new long[]{0x00000000E0000000L});
    public static final BitSet FOLLOW_parse_ASP_RightPattern_in_parse_ASP_Relation296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_parse_ASP_LeftPattern338 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_31_in_parse_ASP_LeftPattern353 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_29_in_parse_ASP_LeftPattern368 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_40_41_in_parse_ASP_LeftPattern393 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_ASP_LeftPattern414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_parse_ASP_RightPattern452 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_31_in_parse_ASP_RightPattern467 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_29_in_parse_ASP_RightPattern482 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_40_41_in_parse_ASP_RightPattern507 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_ASP_RightPattern528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_ASP_Metanode557 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metanode575 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Metanode596 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metanode614 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_ASP_Metanode635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_parse_ASP_Metaprop664 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metaprop682 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Metaprop703 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metaprop721 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Metaprop742 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metaprop760 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_ASP_Metaprop781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_ASP_Metaedge810 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metaedge828 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Metaedge849 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metaedge867 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Metaedge888 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metaedge906 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Metaedge927 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Metaedge945 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_ASP_Metaedge966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_parse_ASP_Node1004 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_24_in_parse_ASP_Node1019 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Node1044 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Node1065 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Node1083 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Node1104 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Node1122 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_ASP_Node1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_parse_ASP_Prop1181 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_27_in_parse_ASP_Prop1196 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Prop1221 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Prop1242 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Prop1260 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Prop1281 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Prop1299 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Prop1320 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Prop1338 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_ASP_Prop1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_parse_ASP_Edge1397 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_18_in_parse_ASP_Edge1412 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Edge1437 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Edge1458 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Edge1476 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Edge1497 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Edge1515 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Edge1536 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Edge1554 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Edge1575 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Edge1593 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_ASP_Edge1614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_NamedFunction1647 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_ASP_NamedFunction1668 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_NamedFunction1686 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_NamedFunction1716 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_NamedFunction1742 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_12_in_parse_ASP_NamedFunction1788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Rule1832 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_parse_ASP_Terminal_in_parse_ASP_Rule1882 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_ASP_Rule1900 = new BitSet(new long[]{0x0000000004000100L});
    public static final BitSet FOLLOW_parse_ASP_Expression_in_parse_ASP_Rule1918 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Rule1945 = new BitSet(new long[]{0x0000000004000100L});
    public static final BitSet FOLLOW_parse_ASP_Expression_in_parse_ASP_Rule1971 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Rule2021 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_ASP_Rule2041 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Rule2067 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_ASP_Rule2113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Constraint2157 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_ASP_Constraint2203 = new BitSet(new long[]{0x0000000004000100L});
    public static final BitSet FOLLOW_parse_ASP_Expression_in_parse_ASP_Constraint2221 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Constraint2248 = new BitSet(new long[]{0x0000000004000100L});
    public static final BitSet FOLLOW_parse_ASP_Expression_in_parse_ASP_Constraint2274 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_parse_ASP_Constraint2324 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_ASP_Constraint2344 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Constraint2370 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_ASP_Constraint2416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Literal2449 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_parse_ASP_Literal2479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Terminal2531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_parse_ASP_Not2567 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Not2585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Eq2625 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_ASP_Eq2646 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_Eq2664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_NotEq2704 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_ASP_NotEq2725 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_ASP_NotEq2743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Metanode_in_parse_ASP_Element2775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Metaprop_in_parse_ASP_Element2785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Metaedge_in_parse_ASP_Element2795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Node_in_parse_ASP_Element2805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Prop_in_parse_ASP_Element2815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Edge_in_parse_ASP_Element2825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_NamedFunction_in_parse_ASP_Element2835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Literal_in_parse_ASP_Element2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Terminal_in_parse_ASP_Element2855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Not_in_parse_ASP_Element2865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Eq_in_parse_ASP_Element2875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_NotEq_in_parse_ASP_Element2885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_LeftPattern_in_parse_ASP_Pattern2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_RightPattern_in_parse_ASP_Pattern2916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Terminal_in_parse_ASP_Expression2937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Not_in_parse_ASP_Expression2947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Eq_in_parse_ASP_Expression2957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_NotEq_in_parse_ASP_Expression2967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Rule_in_synpred3_Asp194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Literal_in_synpred27_Asp2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_Terminal_in_synpred28_Asp2855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_ASP_LeftPattern_in_synpred31_Asp2906 = new BitSet(new long[]{0x0000000000000002L});

}