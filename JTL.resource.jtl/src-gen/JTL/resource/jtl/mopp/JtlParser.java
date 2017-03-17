// $ANTLR 3.4

	package JTL.resource.jtl.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class JtlParser extends JtlANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LINEBREAK", "ML_COMMENT", "SL_COMMENT", "TEXT", "WHITESPACE", "'('", "')'", "','", "':'", "'::'", "';'", "'='", "'checkonly'", "'domain'", "'enforce'", "'false'", "'relation'", "'top'", "'transformation'", "'true'", "'when'", "'where'", "'{'", "'|'", "'}'", "'};'"
    };

    public static final int EOF=-1;
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
    public static final int LINEBREAK=4;
    public static final int ML_COMMENT=5;
    public static final int SL_COMMENT=6;
    public static final int TEXT=7;
    public static final int WHITESPACE=8;

    // delegates
    public JtlANTLRParserBase[] getDelegates() {
        return new JtlANTLRParserBase[] {};
    }

    // delegators


    public JtlParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public JtlParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(49 + 1);
         

    }

    public String[] getTokenNames() { return JtlParser.tokenNames; }
    public String getGrammarFileName() { return "Jtl.g"; }


    	private JTL.resource.jtl.IJtlTokenResolverFactory tokenResolverFactory = new JTL.resource.jtl.mopp.JtlTokenResolverFactory();
    	
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
    	private java.util.List<JTL.resource.jtl.mopp.JtlExpectedTerminal> expectedElements = new java.util.ArrayList<JTL.resource.jtl.mopp.JtlExpectedTerminal>();
    	
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
    		postParseCommands.add(new JTL.resource.jtl.IJtlCommand<JTL.resource.jtl.IJtlTextResource>() {
    			public boolean execute(JTL.resource.jtl.IJtlTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new JTL.resource.jtl.IJtlProblem() {
    					public JTL.resource.jtl.JtlEProblemSeverity getSeverity() {
    						return JTL.resource.jtl.JtlEProblemSeverity.ERROR;
    					}
    					public JTL.resource.jtl.JtlEProblemType getType() {
    						return JTL.resource.jtl.JtlEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<JTL.resource.jtl.IJtlQuickFix> getQuickFixes() {
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
    		JTL.resource.jtl.IJtlExpectedElement terminal = JTL.resource.jtl.grammar.JtlFollowSetProvider.TERMINALS[terminalID];
    		JTL.resource.jtl.mopp.JtlContainedFeature[] containmentFeatures = new JTL.resource.jtl.mopp.JtlContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = JTL.resource.jtl.grammar.JtlFollowSetProvider.LINKS[ids[i]];
    		}
    		JTL.resource.jtl.grammar.JtlContainmentTrace containmentTrace = new JTL.resource.jtl.grammar.JtlContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		JTL.resource.jtl.mopp.JtlExpectedTerminal expectedElement = new JTL.resource.jtl.mopp.JtlExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		postParseCommands.add(new JTL.resource.jtl.IJtlCommand<JTL.resource.jtl.IJtlTextResource>() {
    			public boolean execute(JTL.resource.jtl.IJtlTextResource resource) {
    				JTL.resource.jtl.IJtlLocationMap locationMap = resource.getLocationMap();
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
    		postParseCommands.add(new JTL.resource.jtl.IJtlCommand<JTL.resource.jtl.IJtlTextResource>() {
    			public boolean execute(JTL.resource.jtl.IJtlTextResource resource) {
    				JTL.resource.jtl.IJtlLocationMap locationMap = resource.getLocationMap();
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
    	protected void setLocalizationEnd(java.util.Collection<JTL.resource.jtl.IJtlCommand<JTL.resource.jtl.IJtlTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new JTL.resource.jtl.IJtlCommand<JTL.resource.jtl.IJtlTextResource>() {
    			public boolean execute(JTL.resource.jtl.IJtlTextResource resource) {
    				JTL.resource.jtl.IJtlLocationMap locationMap = resource.getLocationMap();
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
    	
    	public JTL.resource.jtl.IJtlTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new JtlParser(new org.antlr.runtime3_4_0.CommonTokenStream(new JtlLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new JtlParser(new org.antlr.runtime3_4_0.CommonTokenStream(new JtlLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new JTL.resource.jtl.util.JtlRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public JtlParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((JtlLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((JtlLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == JTL.JTL.Transformation.class) {
    				return parse_JTL_JTL_Transformation();
    			}
    			if (type.getInstanceClass() == JTL.JTL.Model.class) {
    				return parse_JTL_JTL_Model();
    			}
    			if (type.getInstanceClass() == JTL.JTL.Relation.class) {
    				return parse_JTL_JTL_Relation();
    			}
    			if (type.getInstanceClass() == JTL.JTL.Domain.class) {
    				return parse_JTL_JTL_Domain();
    			}
    			if (type.getInstanceClass() == JTL.JTL.Pattern.class) {
    				return parse_JTL_JTL_Pattern();
    			}
    			if (type.getInstanceClass() == JTL.JTL.When.class) {
    				return parse_JTL_JTL_When();
    			}
    			if (type.getInstanceClass() == JTL.JTL.Where.class) {
    				return parse_JTL_JTL_Where();
    			}
    			if (type.getInstanceClass() == JTL.JTL.Predicate.class) {
    				return parse_JTL_JTL_Predicate();
    			}
    			if (type.getInstanceClass() == JTL.template.ObjectTemplateExp.class) {
    				return parse_JTL_template_ObjectTemplateExp();
    			}
    			if (type.getInstanceClass() == JTL.imperativeocl.AssignExp.class) {
    				return parse_JTL_imperativeocl_AssignExp();
    			}
    			if (type.getInstanceClass() == JTL.essentialocl.OperationCallExp.class) {
    				return parse_JTL_essentialocl_OperationCallExp();
    			}
    			if (type.getInstanceClass() == JTL.essentialocl.BooleanLiteralExp.class) {
    				return parse_JTL_essentialocl_BooleanLiteralExp();
    			}
    			if (type.getInstanceClass() == JTL.essentialocl.VariableExp.class) {
    				return parse_JTL_essentialocl_VariableExp();
    			}
    			if (type.getInstanceClass() == JTL.essentialocl.StringLiteralExp.class) {
    				return parse_JTL_essentialocl_StringLiteralExp();
    			}
    			if (type.getInstanceClass() == JTL.essentialocl.Variable.class) {
    				return parse_JTL_essentialocl_Variable();
    			}
    		}
    		throw new JTL.resource.jtl.mopp.JtlUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(JTL.resource.jtl.IJtlOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public JTL.resource.jtl.IJtlParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<JTL.resource.jtl.IJtlCommand<JTL.resource.jtl.IJtlTextResource>>();
    		JTL.resource.jtl.mopp.JtlParseResult parseResult = new JTL.resource.jtl.mopp.JtlParseResult();
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
    	
    	public java.util.List<JTL.resource.jtl.mopp.JtlExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, JTL.resource.jtl.IJtlTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		JTL.resource.jtl.IJtlParseResult result = parse();
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
    			for (JTL.resource.jtl.IJtlCommand<JTL.resource.jtl.IJtlTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<JTL.resource.jtl.mopp.JtlExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<JTL.resource.jtl.mopp.JtlExpectedTerminal>();
    		java.util.List<JTL.resource.jtl.mopp.JtlExpectedTerminal> newFollowSet = new java.util.ArrayList<JTL.resource.jtl.mopp.JtlExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			JTL.resource.jtl.mopp.JtlExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 92;
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
    				for (JTL.resource.jtl.mopp.JtlExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (JTL.resource.jtl.mopp.JtlExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<JTL.resource.jtl.util.JtlPair<JTL.resource.jtl.IJtlExpectedElement, JTL.resource.jtl.mopp.JtlContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (JTL.resource.jtl.util.JtlPair<JTL.resource.jtl.IJtlExpectedElement, JTL.resource.jtl.mopp.JtlContainedFeature[]> newFollowerPair : newFollowers) {
    							JTL.resource.jtl.IJtlExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							JTL.resource.jtl.grammar.JtlContainmentTrace containmentTrace = new JTL.resource.jtl.grammar.JtlContainmentTrace(null, newFollowerPair.getRight());
    							JTL.resource.jtl.mopp.JtlExpectedTerminal newFollowTerminal = new JTL.resource.jtl.mopp.JtlExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (JTL.resource.jtl.mopp.JtlExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(JTL.resource.jtl.mopp.JtlExpectedTerminal expectedElement, int tokenIndex) {
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
    // Jtl.g:541:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_JTL_JTL_Transformation ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        JTL.JTL.Transformation c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Jtl.g:542:2: ( (c0= parse_JTL_JTL_Transformation ) EOF )
            // Jtl.g:543:2: (c0= parse_JTL_JTL_Transformation ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Jtl.g:548:2: (c0= parse_JTL_JTL_Transformation )
            // Jtl.g:549:3: c0= parse_JTL_JTL_Transformation
            {
            pushFollow(FOLLOW_parse_JTL_JTL_Transformation_in_start82);
            c0=parse_JTL_JTL_Transformation();

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



    // $ANTLR start "parse_JTL_JTL_Transformation"
    // Jtl.g:557:1: parse_JTL_JTL_Transformation returns [JTL.JTL.Transformation element = null] : a0= 'transformation' (a1= TEXT ) a2= '(' ( ( (a3_0= parse_JTL_JTL_Model ) ( (a4= ',' (a5_0= parse_JTL_JTL_Model ) ) )* ) )? a6= ')' a7= '{' ( ( (a8_0= parse_JTL_JTL_Relation ) ) )+ a9= '}' ;
    public final JTL.JTL.Transformation parse_JTL_JTL_Transformation() throws RecognitionException {
        JTL.JTL.Transformation element =  null;

        int parse_JTL_JTL_Transformation_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        Token a9=null;
        JTL.JTL.Model a3_0 =null;

        JTL.JTL.Model a5_0 =null;

        JTL.JTL.Relation a8_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Jtl.g:560:2: (a0= 'transformation' (a1= TEXT ) a2= '(' ( ( (a3_0= parse_JTL_JTL_Model ) ( (a4= ',' (a5_0= parse_JTL_JTL_Model ) ) )* ) )? a6= ')' a7= '{' ( ( (a8_0= parse_JTL_JTL_Relation ) ) )+ a9= '}' )
            // Jtl.g:561:2: a0= 'transformation' (a1= TEXT ) a2= '(' ( ( (a3_0= parse_JTL_JTL_Model ) ( (a4= ',' (a5_0= parse_JTL_JTL_Model ) ) )* ) )? a6= ')' a7= '{' ( ( (a8_0= parse_JTL_JTL_Relation ) ) )+ a9= '}'
            {
            a0=(Token)match(input,22,FOLLOW_22_in_parse_JTL_JTL_Transformation115); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[1]);
            	}

            // Jtl.g:575:2: (a1= TEXT )
            // Jtl.g:576:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_JTL_JTL_Transformation133); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            			}
            			if (element == null) {
            				element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				JTL.resource.jtl.IJtlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				JTL.resource.jtl.IJtlTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[2]);
            	}

            a2=(Token)match(input,9,FOLLOW_9_in_parse_JTL_JTL_Transformation154); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[3]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[4]);
            	}

            // Jtl.g:626:2: ( ( (a3_0= parse_JTL_JTL_Model ) ( (a4= ',' (a5_0= parse_JTL_JTL_Model ) ) )* ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==TEXT) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Jtl.g:627:3: ( (a3_0= parse_JTL_JTL_Model ) ( (a4= ',' (a5_0= parse_JTL_JTL_Model ) ) )* )
                    {
                    // Jtl.g:627:3: ( (a3_0= parse_JTL_JTL_Model ) ( (a4= ',' (a5_0= parse_JTL_JTL_Model ) ) )* )
                    // Jtl.g:628:4: (a3_0= parse_JTL_JTL_Model ) ( (a4= ',' (a5_0= parse_JTL_JTL_Model ) ) )*
                    {
                    // Jtl.g:628:4: (a3_0= parse_JTL_JTL_Model )
                    // Jtl.g:629:5: a3_0= parse_JTL_JTL_Model
                    {
                    pushFollow(FOLLOW_parse_JTL_JTL_Model_in_parse_JTL_JTL_Transformation183);
                    a3_0=parse_JTL_JTL_Model();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
                    						startIncompleteElement(element);
                    					}
                    					if (a3_0 != null) {
                    						if (a3_0 != null) {
                    							Object value = a3_0;
                    							addObjectToList(element, JTL.JTL.JTLPackage.TRANSFORMATION__MODEL_PARAMETER, value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_4_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[5]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[6]);
                    			}

                    // Jtl.g:655:4: ( (a4= ',' (a5_0= parse_JTL_JTL_Model ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==11) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // Jtl.g:656:5: (a4= ',' (a5_0= parse_JTL_JTL_Model ) )
                    	    {
                    	    // Jtl.g:656:5: (a4= ',' (a5_0= parse_JTL_JTL_Model ) )
                    	    // Jtl.g:657:6: a4= ',' (a5_0= parse_JTL_JTL_Model )
                    	    {
                    	    a4=(Token)match(input,11,FOLLOW_11_in_parse_JTL_JTL_Transformation224); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_4_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[7]);
                    	    					}

                    	    // Jtl.g:671:6: (a5_0= parse_JTL_JTL_Model )
                    	    // Jtl.g:672:7: a5_0= parse_JTL_JTL_Model
                    	    {
                    	    pushFollow(FOLLOW_parse_JTL_JTL_Model_in_parse_JTL_JTL_Transformation258);
                    	    a5_0=parse_JTL_JTL_Model();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    							if (terminateParsing) {
                    	    								throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
                    	    							}
                    	    							if (element == null) {
                    	    								element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
                    	    								startIncompleteElement(element);
                    	    							}
                    	    							if (a5_0 != null) {
                    	    								if (a5_0 != null) {
                    	    									Object value = a5_0;
                    	    									addObjectToList(element, JTL.JTL.JTLPackage.TRANSFORMATION__MODEL_PARAMETER, value);
                    	    									completedElement(value, true);
                    	    								}
                    	    								collectHiddenTokens(element);
                    	    								retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_4_0_0_1_0_0_2, a5_0, true);
                    	    								copyLocalizationInfos(a5_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[8]);
                    	    						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[9]);
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
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[10]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[11]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[12]);
            	}

            a6=(Token)match(input,10,FOLLOW_10_in_parse_JTL_JTL_Transformation332); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[13]);
            	}

            a7=(Token)match(input,26,FOLLOW_26_in_parse_JTL_JTL_Transformation346); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[14]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[15]);
            	}

            // Jtl.g:742:2: ( ( (a8_0= parse_JTL_JTL_Relation ) ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= 20 && LA3_0 <= 21)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Jtl.g:743:3: ( (a8_0= parse_JTL_JTL_Relation ) )
            	    {
            	    // Jtl.g:743:3: ( (a8_0= parse_JTL_JTL_Relation ) )
            	    // Jtl.g:744:4: (a8_0= parse_JTL_JTL_Relation )
            	    {
            	    // Jtl.g:744:4: (a8_0= parse_JTL_JTL_Relation )
            	    // Jtl.g:745:5: a8_0= parse_JTL_JTL_Relation
            	    {
            	    pushFollow(FOLLOW_parse_JTL_JTL_Relation_in_parse_JTL_JTL_Transformation375);
            	    a8_0=parse_JTL_JTL_Relation();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a8_0 != null) {
            	    						if (a8_0 != null) {
            	    							Object value = a8_0;
            	    							addObjectToList(element, JTL.JTL.JTLPackage.TRANSFORMATION__RELATION, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_8_0_0_1, a8_0, true);
            	    						copyLocalizationInfos(a8_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[16]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[17]);
            	    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[18]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[19]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[20]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[21]);
            	}

            a9=(Token)match(input,28,FOLLOW_28_in_parse_JTL_JTL_Transformation416); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_10, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_JTL_JTL_Transformation_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_JTL_Transformation"



    // $ANTLR start "parse_JTL_JTL_Model"
    // Jtl.g:796:1: parse_JTL_JTL_Model returns [JTL.JTL.Model element = null] : (a0= TEXT ) a1= ':' (a2= TEXT ) ;
    public final JTL.JTL.Model parse_JTL_JTL_Model() throws RecognitionException {
        JTL.JTL.Model element =  null;

        int parse_JTL_JTL_Model_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Jtl.g:799:2: ( (a0= TEXT ) a1= ':' (a2= TEXT ) )
            // Jtl.g:800:2: (a0= TEXT ) a1= ':' (a2= TEXT )
            {
            // Jtl.g:800:2: (a0= TEXT )
            // Jtl.g:801:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_JTL_JTL_Model449); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            			}
            			if (element == null) {
            				element = JTL.JTL.JTLFactory.eINSTANCE.createModel();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				JTL.resource.jtl.IJtlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				JTL.resource.jtl.IJtlTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_1_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[22]);
            	}

            a1=(Token)match(input,12,FOLLOW_12_in_parse_JTL_JTL_Model470); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_1_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[23]);
            	}

            // Jtl.g:850:2: (a2= TEXT )
            // Jtl.g:851:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_JTL_JTL_Model488); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            			}
            			if (element == null) {
            				element = JTL.JTL.JTLFactory.eINSTANCE.createModel();
            				startIncompleteElement(element);
            			}
            			if (a2 != null) {
            				JTL.resource.jtl.IJtlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				JTL.resource.jtl.IJtlTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__USED_PACKAGE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__USED_PACKAGE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_1_0_0_2, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[24]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[25]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_JTL_JTL_Model_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_JTL_Model"



    // $ANTLR start "parse_JTL_JTL_Relation"
    // Jtl.g:889:1: parse_JTL_JTL_Relation returns [JTL.JTL.Relation element = null] : ( (a0= 'top' )? ) a3= 'relation' (a4= TEXT ) a5= '{' ( ( (a6_0= parse_JTL_essentialocl_Variable ) ) )* ( ( (a7_0= parse_JTL_JTL_Domain ) ) )* ( ( (a8_0= parse_JTL_JTL_When ) ) )? ( ( (a9_0= parse_JTL_JTL_Where ) ) )? a10= '}' ;
    public final JTL.JTL.Relation parse_JTL_JTL_Relation() throws RecognitionException {
        JTL.JTL.Relation element =  null;

        int parse_JTL_JTL_Relation_StartIndex = input.index();

        Token a0=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a10=null;
        JTL.essentialocl.Variable a6_0 =null;

        JTL.JTL.Domain a7_0 =null;

        JTL.JTL.When a8_0 =null;

        JTL.JTL.Where a9_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Jtl.g:892:2: ( ( (a0= 'top' )? ) a3= 'relation' (a4= TEXT ) a5= '{' ( ( (a6_0= parse_JTL_essentialocl_Variable ) ) )* ( ( (a7_0= parse_JTL_JTL_Domain ) ) )* ( ( (a8_0= parse_JTL_JTL_When ) ) )? ( ( (a9_0= parse_JTL_JTL_Where ) ) )? a10= '}' )
            // Jtl.g:893:2: ( (a0= 'top' )? ) a3= 'relation' (a4= TEXT ) a5= '{' ( ( (a6_0= parse_JTL_essentialocl_Variable ) ) )* ( ( (a7_0= parse_JTL_JTL_Domain ) ) )* ( ( (a8_0= parse_JTL_JTL_When ) ) )? ( ( (a9_0= parse_JTL_JTL_Where ) ) )? a10= '}'
            {
            // Jtl.g:893:2: ( (a0= 'top' )? )
            // Jtl.g:894:3: (a0= 'top' )?
            {
            // Jtl.g:894:3: (a0= 'top' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Jtl.g:895:4: a0= 'top'
                    {
                    a0=(Token)match(input,21,FOLLOW_21_in_parse_JTL_JTL_Relation533); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = JTL.JTL.JTLFactory.eINSTANCE.createRelation();
                    					startIncompleteElement(element);
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__IS_TOP_LEVEL), value);
                    					}
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_2_0_0_0, true, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    				// set value of boolean attribute
                    				Object value = true;
                    				element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__IS_TOP_LEVEL), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[26]);
            	}

            a3=(Token)match(input,20,FOLLOW_20_in_parse_JTL_JTL_Relation554); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createRelation();
            			startIncompleteElement(element);
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__IS_TOP_LEVEL), value);
            			}
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_2_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[27]);
            	}

            // Jtl.g:938:2: (a4= TEXT )
            // Jtl.g:939:3: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_JTL_JTL_Relation572); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            			}
            			if (element == null) {
            				element = JTL.JTL.JTLFactory.eINSTANCE.createRelation();
            				startIncompleteElement(element);
            				// initialize boolean attribute
            				{
            					Object value = false;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__IS_TOP_LEVEL), value);
            				}
            			}
            			if (a4 != null) {
            				JTL.resource.jtl.IJtlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				JTL.resource.jtl.IJtlTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_2_0_0_2, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[28]);
            	}

            a5=(Token)match(input,26,FOLLOW_26_in_parse_JTL_JTL_Relation593); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createRelation();
            			startIncompleteElement(element);
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__IS_TOP_LEVEL), value);
            			}
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_2_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[29]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[30]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[31]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[32]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[33]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[34]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[35]);
            	}

            // Jtl.g:1004:2: ( ( (a6_0= parse_JTL_essentialocl_Variable ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==TEXT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Jtl.g:1005:3: ( (a6_0= parse_JTL_essentialocl_Variable ) )
            	    {
            	    // Jtl.g:1005:3: ( (a6_0= parse_JTL_essentialocl_Variable ) )
            	    // Jtl.g:1006:4: (a6_0= parse_JTL_essentialocl_Variable )
            	    {
            	    // Jtl.g:1006:4: (a6_0= parse_JTL_essentialocl_Variable )
            	    // Jtl.g:1007:5: a6_0= parse_JTL_essentialocl_Variable
            	    {
            	    pushFollow(FOLLOW_parse_JTL_essentialocl_Variable_in_parse_JTL_JTL_Relation622);
            	    a6_0=parse_JTL_essentialocl_Variable();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = JTL.JTL.JTLFactory.eINSTANCE.createRelation();
            	    						startIncompleteElement(element);
            	    						// initialize boolean attribute
            	    						{
            	    							Object value = false;
            	    							element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__IS_TOP_LEVEL), value);
            	    						}
            	    					}
            	    					if (a6_0 != null) {
            	    						if (a6_0 != null) {
            	    							Object value = a6_0;
            	    							addObjectToList(element, JTL.JTL.JTLPackage.RELATION__VARIABLE, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_2_0_0_5_0_0_1, a6_0, true);
            	    						copyLocalizationInfos(a6_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[36]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[37]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[38]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[39]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[40]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[41]);
            	    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[42]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[43]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[44]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[45]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[46]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[47]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[48]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[49]);
            	}

            // Jtl.g:1056:2: ( ( (a7_0= parse_JTL_JTL_Domain ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= 16 && LA6_0 <= 18)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Jtl.g:1057:3: ( (a7_0= parse_JTL_JTL_Domain ) )
            	    {
            	    // Jtl.g:1057:3: ( (a7_0= parse_JTL_JTL_Domain ) )
            	    // Jtl.g:1058:4: (a7_0= parse_JTL_JTL_Domain )
            	    {
            	    // Jtl.g:1058:4: (a7_0= parse_JTL_JTL_Domain )
            	    // Jtl.g:1059:5: a7_0= parse_JTL_JTL_Domain
            	    {
            	    pushFollow(FOLLOW_parse_JTL_JTL_Domain_in_parse_JTL_JTL_Relation678);
            	    a7_0=parse_JTL_JTL_Domain();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = JTL.JTL.JTLFactory.eINSTANCE.createRelation();
            	    						startIncompleteElement(element);
            	    						// initialize boolean attribute
            	    						{
            	    							Object value = false;
            	    							element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__IS_TOP_LEVEL), value);
            	    						}
            	    					}
            	    					if (a7_0 != null) {
            	    						if (a7_0 != null) {
            	    							Object value = a7_0;
            	    							addObjectToList(element, JTL.JTL.JTLPackage.RELATION__DOMAIN, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_2_0_0_6_0_0_1, a7_0, true);
            	    						copyLocalizationInfos(a7_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[50]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[51]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[52]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[53]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[54]);
            	    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[55]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[56]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[57]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[58]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[59]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[60]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[61]);
            	}

            // Jtl.g:1106:2: ( ( (a8_0= parse_JTL_JTL_When ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Jtl.g:1107:3: ( (a8_0= parse_JTL_JTL_When ) )
                    {
                    // Jtl.g:1107:3: ( (a8_0= parse_JTL_JTL_When ) )
                    // Jtl.g:1108:4: (a8_0= parse_JTL_JTL_When )
                    {
                    // Jtl.g:1108:4: (a8_0= parse_JTL_JTL_When )
                    // Jtl.g:1109:5: a8_0= parse_JTL_JTL_When
                    {
                    pushFollow(FOLLOW_parse_JTL_JTL_When_in_parse_JTL_JTL_Relation734);
                    a8_0=parse_JTL_JTL_When();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = JTL.JTL.JTLFactory.eINSTANCE.createRelation();
                    						startIncompleteElement(element);
                    						// initialize boolean attribute
                    						{
                    							Object value = false;
                    							element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__IS_TOP_LEVEL), value);
                    						}
                    					}
                    					if (a8_0 != null) {
                    						if (a8_0 != null) {
                    							Object value = a8_0;
                    							element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__WHEN), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_2_0_0_7_0_0_1, a8_0, true);
                    						copyLocalizationInfos(a8_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[62]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[63]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[64]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[65]);
            	}

            // Jtl.g:1148:2: ( ( (a9_0= parse_JTL_JTL_Where ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==25) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Jtl.g:1149:3: ( (a9_0= parse_JTL_JTL_Where ) )
                    {
                    // Jtl.g:1149:3: ( (a9_0= parse_JTL_JTL_Where ) )
                    // Jtl.g:1150:4: (a9_0= parse_JTL_JTL_Where )
                    {
                    // Jtl.g:1150:4: (a9_0= parse_JTL_JTL_Where )
                    // Jtl.g:1151:5: a9_0= parse_JTL_JTL_Where
                    {
                    pushFollow(FOLLOW_parse_JTL_JTL_Where_in_parse_JTL_JTL_Relation790);
                    a9_0=parse_JTL_JTL_Where();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = JTL.JTL.JTLFactory.eINSTANCE.createRelation();
                    						startIncompleteElement(element);
                    						// initialize boolean attribute
                    						{
                    							Object value = false;
                    							element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__IS_TOP_LEVEL), value);
                    						}
                    					}
                    					if (a9_0 != null) {
                    						if (a9_0 != null) {
                    							Object value = a9_0;
                    							element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__WHERE), value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_2_0_0_8_0_0_1, a9_0, true);
                    						copyLocalizationInfos(a9_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[66]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[67]);
            	}

            a10=(Token)match(input,28,FOLLOW_28_in_parse_JTL_JTL_Relation831); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createRelation();
            			startIncompleteElement(element);
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__IS_TOP_LEVEL), value);
            			}
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_2_0_0_10, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[68]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[69]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[70]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_JTL_JTL_Relation_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_JTL_Relation"



    // $ANTLR start "parse_JTL_JTL_Domain"
    // Jtl.g:1211:1: parse_JTL_JTL_Domain returns [JTL.JTL.Domain element = null] : ( (a0= 'checkonly' )? ) ( (a3= 'enforce' )? ) a6= 'domain' (a7= TEXT ) (a8_0= parse_JTL_JTL_Pattern ) ;
    public final JTL.JTL.Domain parse_JTL_JTL_Domain() throws RecognitionException {
        JTL.JTL.Domain element =  null;

        int parse_JTL_JTL_Domain_StartIndex = input.index();

        Token a0=null;
        Token a3=null;
        Token a6=null;
        Token a7=null;
        JTL.JTL.Pattern a8_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Jtl.g:1214:2: ( ( (a0= 'checkonly' )? ) ( (a3= 'enforce' )? ) a6= 'domain' (a7= TEXT ) (a8_0= parse_JTL_JTL_Pattern ) )
            // Jtl.g:1215:2: ( (a0= 'checkonly' )? ) ( (a3= 'enforce' )? ) a6= 'domain' (a7= TEXT ) (a8_0= parse_JTL_JTL_Pattern )
            {
            // Jtl.g:1215:2: ( (a0= 'checkonly' )? )
            // Jtl.g:1216:3: (a0= 'checkonly' )?
            {
            // Jtl.g:1216:3: (a0= 'checkonly' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Jtl.g:1217:4: a0= 'checkonly'
                    {
                    a0=(Token)match(input,16,FOLLOW_16_in_parse_JTL_JTL_Domain869); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = JTL.JTL.JTLFactory.eINSTANCE.createDomain();
                    					startIncompleteElement(element);
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_CHECKABLE), value);
                    					}
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_ENFORCEABLE), value);
                    					}
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_3_0_0_0, true, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    				// set value of boolean attribute
                    				Object value = true;
                    				element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_CHECKABLE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[71]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[72]);
            	}

            // Jtl.g:1247:2: ( (a3= 'enforce' )? )
            // Jtl.g:1248:3: (a3= 'enforce' )?
            {
            // Jtl.g:1248:3: (a3= 'enforce' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Jtl.g:1249:4: a3= 'enforce'
                    {
                    a3=(Token)match(input,18,FOLLOW_18_in_parse_JTL_JTL_Domain899); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = JTL.JTL.JTLFactory.eINSTANCE.createDomain();
                    					startIncompleteElement(element);
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_CHECKABLE), value);
                    					}
                    					// initialize boolean attribute
                    					{
                    						Object value = false;
                    						element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_ENFORCEABLE), value);
                    					}
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_3_0_0_1, true, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    				// set value of boolean attribute
                    				Object value = true;
                    				element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_ENFORCEABLE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[73]);
            	}

            a6=(Token)match(input,17,FOLLOW_17_in_parse_JTL_JTL_Domain920); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createDomain();
            			startIncompleteElement(element);
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_CHECKABLE), value);
            			}
            			// initialize boolean attribute
            			{
            				Object value = false;
            				element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_ENFORCEABLE), value);
            			}
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_3_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[74]);
            	}

            // Jtl.g:1302:2: (a7= TEXT )
            // Jtl.g:1303:3: a7= TEXT
            {
            a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_JTL_JTL_Domain938); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            			}
            			if (element == null) {
            				element = JTL.JTL.JTLFactory.eINSTANCE.createDomain();
            				startIncompleteElement(element);
            				// initialize boolean attribute
            				{
            					Object value = false;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_CHECKABLE), value);
            				}
            				// initialize boolean attribute
            				{
            					Object value = false;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_ENFORCEABLE), value);
            				}
            			}
            			if (a7 != null) {
            				JTL.resource.jtl.IJtlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				JTL.resource.jtl.IJtlTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_3_0_0_3, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getDomain(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[75]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getDomain(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[76]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getDomain(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[77]);
            	}

            // Jtl.g:1350:2: (a8_0= parse_JTL_JTL_Pattern )
            // Jtl.g:1351:3: a8_0= parse_JTL_JTL_Pattern
            {
            pushFollow(FOLLOW_parse_JTL_JTL_Pattern_in_parse_JTL_JTL_Domain963);
            a8_0=parse_JTL_JTL_Pattern();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            			}
            			if (element == null) {
            				element = JTL.JTL.JTLFactory.eINSTANCE.createDomain();
            				startIncompleteElement(element);
            				// initialize boolean attribute
            				{
            					Object value = false;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_CHECKABLE), value);
            				}
            				// initialize boolean attribute
            				{
            					Object value = false;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_ENFORCEABLE), value);
            				}
            			}
            			if (a8_0 != null) {
            				if (a8_0 != null) {
            					Object value = a8_0;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__PATTERN), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_3_0_0_4, a8_0, true);
            				copyLocalizationInfos(a8_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[78]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[79]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[80]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[81]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[82]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[83]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_JTL_JTL_Domain_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_JTL_Domain"



    // $ANTLR start "parse_JTL_JTL_Pattern"
    // Jtl.g:1393:1: parse_JTL_JTL_Pattern returns [JTL.JTL.Pattern element = null] : ( (a0_0= parse_JTL_template_TemplateExp ) a1= '{' ( ( (a2_0= parse_JTL_JTL_Predicate ) ( (a3= ',' (a4_0= parse_JTL_JTL_Predicate ) ) )* ) )? a5= '};' |c0= parse_JTL_JTL_When |c1= parse_JTL_JTL_Where );
    public final JTL.JTL.Pattern parse_JTL_JTL_Pattern() throws RecognitionException {
        JTL.JTL.Pattern element =  null;

        int parse_JTL_JTL_Pattern_StartIndex = input.index();

        Token a1=null;
        Token a3=null;
        Token a5=null;
        JTL.template.TemplateExp a0_0 =null;

        JTL.JTL.Predicate a2_0 =null;

        JTL.JTL.Predicate a4_0 =null;

        JTL.JTL.When c0 =null;

        JTL.JTL.Where c1 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Jtl.g:1396:2: ( (a0_0= parse_JTL_template_TemplateExp ) a1= '{' ( ( (a2_0= parse_JTL_JTL_Predicate ) ( (a3= ',' (a4_0= parse_JTL_JTL_Predicate ) ) )* ) )? a5= '};' |c0= parse_JTL_JTL_When |c1= parse_JTL_JTL_Where )
            int alt13=3;
            switch ( input.LA(1) ) {
            case TEXT:
                {
                alt13=1;
                }
                break;
            case 24:
                {
                alt13=2;
                }
                break;
            case 25:
                {
                alt13=3;
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
                    // Jtl.g:1397:2: (a0_0= parse_JTL_template_TemplateExp ) a1= '{' ( ( (a2_0= parse_JTL_JTL_Predicate ) ( (a3= ',' (a4_0= parse_JTL_JTL_Predicate ) ) )* ) )? a5= '};'
                    {
                    // Jtl.g:1397:2: (a0_0= parse_JTL_template_TemplateExp )
                    // Jtl.g:1398:3: a0_0= parse_JTL_template_TemplateExp
                    {
                    pushFollow(FOLLOW_parse_JTL_template_TemplateExp_in_parse_JTL_JTL_Pattern1000);
                    a0_0=parse_JTL_template_TemplateExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    			if (terminateParsing) {
                    				throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
                    			}
                    			if (element == null) {
                    				element = JTL.JTL.JTLFactory.eINSTANCE.createPattern();
                    				startIncompleteElement(element);
                    			}
                    			if (a0_0 != null) {
                    				if (a0_0 != null) {
                    					Object value = a0_0;
                    					element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PATTERN__TEMPLATE_EXPRESSION), value);
                    					completedElement(value, true);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_4_0_0_0, a0_0, true);
                    				copyLocalizationInfos(a0_0, element);
                    			}
                    		}

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[84]);
                    	}

                    a1=(Token)match(input,26,FOLLOW_26_in_parse_JTL_JTL_Pattern1018); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = JTL.JTL.JTLFactory.eINSTANCE.createPattern();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_4_0_0_2, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[85]);
                    		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[86]);
                    		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[87]);
                    		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[88]);
                    		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[89]);
                    		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[90]);
                    		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[91]);
                    	}

                    // Jtl.g:1443:2: ( ( (a2_0= parse_JTL_JTL_Predicate ) ( (a3= ',' (a4_0= parse_JTL_JTL_Predicate ) ) )* ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==TEXT||LA12_0==19||LA12_0==23||LA12_0==27) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // Jtl.g:1444:3: ( (a2_0= parse_JTL_JTL_Predicate ) ( (a3= ',' (a4_0= parse_JTL_JTL_Predicate ) ) )* )
                            {
                            // Jtl.g:1444:3: ( (a2_0= parse_JTL_JTL_Predicate ) ( (a3= ',' (a4_0= parse_JTL_JTL_Predicate ) ) )* )
                            // Jtl.g:1445:4: (a2_0= parse_JTL_JTL_Predicate ) ( (a3= ',' (a4_0= parse_JTL_JTL_Predicate ) ) )*
                            {
                            // Jtl.g:1445:4: (a2_0= parse_JTL_JTL_Predicate )
                            // Jtl.g:1446:5: a2_0= parse_JTL_JTL_Predicate
                            {
                            pushFollow(FOLLOW_parse_JTL_JTL_Predicate_in_parse_JTL_JTL_Pattern1047);
                            a2_0=parse_JTL_JTL_Predicate();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (terminateParsing) {
                            						throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
                            					}
                            					if (element == null) {
                            						element = JTL.JTL.JTLFactory.eINSTANCE.createPattern();
                            						startIncompleteElement(element);
                            					}
                            					if (a2_0 != null) {
                            						if (a2_0 != null) {
                            							Object value = a2_0;
                            							addObjectToList(element, JTL.JTL.JTLPackage.PATTERN__PREDICATE, value);
                            							completedElement(value, true);
                            						}
                            						collectHiddenTokens(element);
                            						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_4_0_0_3_0_0_1, a2_0, true);
                            						copyLocalizationInfos(a2_0, element);
                            					}
                            				}

                            }


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[92]);
                            				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[93]);
                            			}

                            // Jtl.g:1472:4: ( (a3= ',' (a4_0= parse_JTL_JTL_Predicate ) ) )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==11) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // Jtl.g:1473:5: (a3= ',' (a4_0= parse_JTL_JTL_Predicate ) )
                            	    {
                            	    // Jtl.g:1473:5: (a3= ',' (a4_0= parse_JTL_JTL_Predicate ) )
                            	    // Jtl.g:1474:6: a3= ',' (a4_0= parse_JTL_JTL_Predicate )
                            	    {
                            	    a3=(Token)match(input,11,FOLLOW_11_in_parse_JTL_JTL_Pattern1088); if (state.failed) return element;

                            	    if ( state.backtracking==0 ) {
                            	    						if (element == null) {
                            	    							element = JTL.JTL.JTLFactory.eINSTANCE.createPattern();
                            	    							startIncompleteElement(element);
                            	    						}
                            	    						collectHiddenTokens(element);
                            	    						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_4_0_0_3_0_0_2_0_0_0, null, true);
                            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                            	    					}

                            	    if ( state.backtracking==0 ) {
                            	    						// expected elements (follow set)
                            	    						addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[94]);
                            	    						addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[95]);
                            	    						addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[96]);
                            	    						addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[97]);
                            	    						addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[98]);
                            	    						addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[99]);
                            	    					}

                            	    // Jtl.g:1493:6: (a4_0= parse_JTL_JTL_Predicate )
                            	    // Jtl.g:1494:7: a4_0= parse_JTL_JTL_Predicate
                            	    {
                            	    pushFollow(FOLLOW_parse_JTL_JTL_Predicate_in_parse_JTL_JTL_Pattern1122);
                            	    a4_0=parse_JTL_JTL_Predicate();

                            	    state._fsp--;
                            	    if (state.failed) return element;

                            	    if ( state.backtracking==0 ) {
                            	    							if (terminateParsing) {
                            	    								throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
                            	    							}
                            	    							if (element == null) {
                            	    								element = JTL.JTL.JTLFactory.eINSTANCE.createPattern();
                            	    								startIncompleteElement(element);
                            	    							}
                            	    							if (a4_0 != null) {
                            	    								if (a4_0 != null) {
                            	    									Object value = a4_0;
                            	    									addObjectToList(element, JTL.JTL.JTLPackage.PATTERN__PREDICATE, value);
                            	    									completedElement(value, true);
                            	    								}
                            	    								collectHiddenTokens(element);
                            	    								retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_4_0_0_3_0_0_2_0_0_2, a4_0, true);
                            	    								copyLocalizationInfos(a4_0, element);
                            	    							}
                            	    						}

                            	    }


                            	    if ( state.backtracking==0 ) {
                            	    						// expected elements (follow set)
                            	    						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[100]);
                            	    						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[101]);
                            	    					}

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[102]);
                            				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[103]);
                            			}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[104]);
                    	}

                    a5=(Token)match(input,29,FOLLOW_29_in_parse_JTL_JTL_Pattern1196); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    		if (element == null) {
                    			element = JTL.JTL.JTLFactory.eINSTANCE.createPattern();
                    			startIncompleteElement(element);
                    		}
                    		collectHiddenTokens(element);
                    		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_4_0_0_4, null, true);
                    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    	}

                    if ( state.backtracking==0 ) {
                    		// expected elements (follow set)
                    		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[105]);
                    		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[106]);
                    		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[107]);
                    		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[108]);
                    		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[109]);
                    		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[110]);
                    	}

                    }
                    break;
                case 2 :
                    // Jtl.g:1556:2: c0= parse_JTL_JTL_When
                    {
                    pushFollow(FOLLOW_parse_JTL_JTL_When_in_parse_JTL_JTL_Pattern1215);
                    c0=parse_JTL_JTL_When();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Jtl.g:1557:4: c1= parse_JTL_JTL_Where
                    {
                    pushFollow(FOLLOW_parse_JTL_JTL_Where_in_parse_JTL_JTL_Pattern1225);
                    c1=parse_JTL_JTL_Where();

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
            if ( state.backtracking>0 ) { memoize(input, 6, parse_JTL_JTL_Pattern_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_JTL_Pattern"



    // $ANTLR start "parse_JTL_JTL_When"
    // Jtl.g:1561:1: parse_JTL_JTL_When returns [JTL.JTL.When element = null] : a0= 'when' a1= '{' ( ( (a2_0= parse_JTL_JTL_Predicate ) a3= ';' ) )* a4= '}' ;
    public final JTL.JTL.When parse_JTL_JTL_When() throws RecognitionException {
        JTL.JTL.When element =  null;

        int parse_JTL_JTL_When_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a4=null;
        JTL.JTL.Predicate a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Jtl.g:1564:2: (a0= 'when' a1= '{' ( ( (a2_0= parse_JTL_JTL_Predicate ) a3= ';' ) )* a4= '}' )
            // Jtl.g:1565:2: a0= 'when' a1= '{' ( ( (a2_0= parse_JTL_JTL_Predicate ) a3= ';' ) )* a4= '}'
            {
            a0=(Token)match(input,24,FOLLOW_24_in_parse_JTL_JTL_When1250); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createWhen();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_5_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[111]);
            	}

            a1=(Token)match(input,26,FOLLOW_26_in_parse_JTL_JTL_When1264); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createWhen();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_5_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[112]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[113]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[114]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[115]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[116]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[117]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[118]);
            	}

            // Jtl.g:1599:2: ( ( (a2_0= parse_JTL_JTL_Predicate ) a3= ';' ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==TEXT||LA14_0==19||LA14_0==23||LA14_0==27) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // Jtl.g:1600:3: ( (a2_0= parse_JTL_JTL_Predicate ) a3= ';' )
            	    {
            	    // Jtl.g:1600:3: ( (a2_0= parse_JTL_JTL_Predicate ) a3= ';' )
            	    // Jtl.g:1601:4: (a2_0= parse_JTL_JTL_Predicate ) a3= ';'
            	    {
            	    // Jtl.g:1601:4: (a2_0= parse_JTL_JTL_Predicate )
            	    // Jtl.g:1602:5: a2_0= parse_JTL_JTL_Predicate
            	    {
            	    pushFollow(FOLLOW_parse_JTL_JTL_Predicate_in_parse_JTL_JTL_When1293);
            	    a2_0=parse_JTL_JTL_Predicate();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = JTL.JTL.JTLFactory.eINSTANCE.createWhen();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, JTL.JTL.JTLPackage.WHEN__PREDICATE, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_5_0_0_3_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[119]);
            	    			}

            	    a3=(Token)match(input,14,FOLLOW_14_in_parse_JTL_JTL_When1321); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = JTL.JTL.JTLFactory.eINSTANCE.createWhen();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_5_0_0_3_0_0_2, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[120]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[121]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[122]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[123]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[124]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[125]);
            	    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[126]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[127]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[128]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[129]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[130]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[131]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[132]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[133]);
            	}

            a4=(Token)match(input,28,FOLLOW_28_in_parse_JTL_JTL_When1354); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createWhen();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_5_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[134]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[135]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_JTL_JTL_When_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_JTL_When"



    // $ANTLR start "parse_JTL_JTL_Where"
    // Jtl.g:1677:1: parse_JTL_JTL_Where returns [JTL.JTL.Where element = null] : a0= 'where' a1= '{' ( ( (a2_0= parse_JTL_JTL_Predicate ) a3= ';' ) )* a4= '}' ;
    public final JTL.JTL.Where parse_JTL_JTL_Where() throws RecognitionException {
        JTL.JTL.Where element =  null;

        int parse_JTL_JTL_Where_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a4=null;
        JTL.JTL.Predicate a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Jtl.g:1680:2: (a0= 'where' a1= '{' ( ( (a2_0= parse_JTL_JTL_Predicate ) a3= ';' ) )* a4= '}' )
            // Jtl.g:1681:2: a0= 'where' a1= '{' ( ( (a2_0= parse_JTL_JTL_Predicate ) a3= ';' ) )* a4= '}'
            {
            a0=(Token)match(input,25,FOLLOW_25_in_parse_JTL_JTL_Where1383); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createWhere();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_6_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[136]);
            	}

            a1=(Token)match(input,26,FOLLOW_26_in_parse_JTL_JTL_Where1397); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createWhere();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_6_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[137]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[138]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[139]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[140]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[141]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[142]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[143]);
            	}

            // Jtl.g:1715:2: ( ( (a2_0= parse_JTL_JTL_Predicate ) a3= ';' ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==TEXT||LA15_0==19||LA15_0==23||LA15_0==27) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // Jtl.g:1716:3: ( (a2_0= parse_JTL_JTL_Predicate ) a3= ';' )
            	    {
            	    // Jtl.g:1716:3: ( (a2_0= parse_JTL_JTL_Predicate ) a3= ';' )
            	    // Jtl.g:1717:4: (a2_0= parse_JTL_JTL_Predicate ) a3= ';'
            	    {
            	    // Jtl.g:1717:4: (a2_0= parse_JTL_JTL_Predicate )
            	    // Jtl.g:1718:5: a2_0= parse_JTL_JTL_Predicate
            	    {
            	    pushFollow(FOLLOW_parse_JTL_JTL_Predicate_in_parse_JTL_JTL_Where1426);
            	    a2_0=parse_JTL_JTL_Predicate();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = JTL.JTL.JTLFactory.eINSTANCE.createWhere();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, JTL.JTL.JTLPackage.WHERE__PREDICATE, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_6_0_0_3_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[144]);
            	    			}

            	    a3=(Token)match(input,14,FOLLOW_14_in_parse_JTL_JTL_Where1454); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = JTL.JTL.JTLFactory.eINSTANCE.createWhere();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_6_0_0_3_0_0_2, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[145]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[146]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[147]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[148]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[149]);
            	    				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[150]);
            	    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[151]);
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
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[152]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[153]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[154]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[155]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[156]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[157]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[158]);
            	}

            a4=(Token)match(input,28,FOLLOW_28_in_parse_JTL_JTL_Where1487); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.JTL.JTLFactory.eINSTANCE.createWhere();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_6_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[159]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_JTL_JTL_Where_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_JTL_Where"



    // $ANTLR start "parse_JTL_JTL_Predicate"
    // Jtl.g:1792:1: parse_JTL_JTL_Predicate returns [JTL.JTL.Predicate element = null] : (a0_0= parse_JTL_essentialocl_OclExpression ) ;
    public final JTL.JTL.Predicate parse_JTL_JTL_Predicate() throws RecognitionException {
        JTL.JTL.Predicate element =  null;

        int parse_JTL_JTL_Predicate_StartIndex = input.index();

        JTL.essentialocl.OclExpression a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Jtl.g:1795:2: ( (a0_0= parse_JTL_essentialocl_OclExpression ) )
            // Jtl.g:1796:2: (a0_0= parse_JTL_essentialocl_OclExpression )
            {
            // Jtl.g:1796:2: (a0_0= parse_JTL_essentialocl_OclExpression )
            // Jtl.g:1797:3: a0_0= parse_JTL_essentialocl_OclExpression
            {
            pushFollow(FOLLOW_parse_JTL_essentialocl_OclExpression_in_parse_JTL_JTL_Predicate1520);
            a0_0=parse_JTL_essentialocl_OclExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            			}
            			if (element == null) {
            				element = JTL.JTL.JTLFactory.eINSTANCE.createPredicate();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PREDICATE__CONDITION_EXPRESSION), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_7_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[160]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[161]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[162]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[163]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_JTL_JTL_Predicate_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_JTL_Predicate"



    // $ANTLR start "parse_JTL_template_ObjectTemplateExp"
    // Jtl.g:1827:1: parse_JTL_template_ObjectTemplateExp returns [JTL.template.ObjectTemplateExp element = null] : (a0= TEXT ) a1= ':' ( ( (a2= TEXT ) ) )? ( (a3= '::' (a4= TEXT ) ) )? ( (a5= '{' ( ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* ) )? a9= '}' ) )? ;
    public final JTL.template.ObjectTemplateExp parse_JTL_template_ObjectTemplateExp() throws RecognitionException {
        JTL.template.ObjectTemplateExp element =  null;

        int parse_JTL_template_ObjectTemplateExp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a7=null;
        Token a9=null;
        JTL.imperativeocl.AssignExp a6_0 =null;

        JTL.imperativeocl.AssignExp a8_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Jtl.g:1830:2: ( (a0= TEXT ) a1= ':' ( ( (a2= TEXT ) ) )? ( (a3= '::' (a4= TEXT ) ) )? ( (a5= '{' ( ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* ) )? a9= '}' ) )? )
            // Jtl.g:1831:2: (a0= TEXT ) a1= ':' ( ( (a2= TEXT ) ) )? ( (a3= '::' (a4= TEXT ) ) )? ( (a5= '{' ( ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* ) )? a9= '}' ) )?
            {
            // Jtl.g:1831:2: (a0= TEXT )
            // Jtl.g:1832:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_JTL_template_ObjectTemplateExp1557); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            			}
            			if (element == null) {
            				element = JTL.template.TemplateFactory.eINSTANCE.createObjectTemplateExp();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				JTL.resource.jtl.IJtlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				JTL.resource.jtl.IJtlTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_8_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[164]);
            	}

            a1=(Token)match(input,12,FOLLOW_12_in_parse_JTL_template_ObjectTemplateExp1578); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.template.TemplateFactory.eINSTANCE.createObjectTemplateExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_8_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[165]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[166]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[167]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[168]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[169]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[170]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[171]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[172]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[173]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[174]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[175]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[176]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[177]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[178]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[179]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[180]);
            	}

            // Jtl.g:1896:2: ( ( (a2= TEXT ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==TEXT) ) {
                int LA16_1 = input.LA(2);

                if ( (synpred17_Jtl()) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // Jtl.g:1897:3: ( (a2= TEXT ) )
                    {
                    // Jtl.g:1897:3: ( (a2= TEXT ) )
                    // Jtl.g:1898:4: (a2= TEXT )
                    {
                    // Jtl.g:1898:4: (a2= TEXT )
                    // Jtl.g:1899:5: a2= TEXT
                    {
                    a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_JTL_template_ObjectTemplateExp1607); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = JTL.template.TemplateFactory.eINSTANCE.createObjectTemplateExp();
                    						startIncompleteElement(element);
                    					}
                    					if (a2 != null) {
                    						JTL.resource.jtl.IJtlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    						tokenResolver.setOptions(getOptions());
                    						JTL.resource.jtl.IJtlTokenResolveResult result = getFreshTokenResolveResult();
                    						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__TYPE), result);
                    						Object resolvedObject = result.getResolvedToken();
                    						if (resolvedObject == null) {
                    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
                    						}
                    						java.lang.String resolved = (java.lang.String) resolvedObject;
                    						if (resolved != null) {
                    							Object value = resolved;
                    							element.eSet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__TYPE), value);
                    							completedElement(value, false);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_8_0_0_3_0_0_1, resolved, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[181]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[182]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[183]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[184]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[185]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[186]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[187]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[188]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[189]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[190]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[191]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[192]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[193]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[194]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[195]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[196]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[197]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[198]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[199]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[200]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[201]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[202]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[203]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[204]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[205]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[206]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[207]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[208]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[209]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[210]);
            	}

            // Jtl.g:1969:2: ( (a3= '::' (a4= TEXT ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==13) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // Jtl.g:1970:3: (a3= '::' (a4= TEXT ) )
                    {
                    // Jtl.g:1970:3: (a3= '::' (a4= TEXT ) )
                    // Jtl.g:1971:4: a3= '::' (a4= TEXT )
                    {
                    a3=(Token)match(input,13,FOLLOW_13_in_parse_JTL_template_ObjectTemplateExp1662); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = JTL.template.TemplateFactory.eINSTANCE.createObjectTemplateExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_8_0_0_4_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[211]);
                    			}

                    // Jtl.g:1985:4: (a4= TEXT )
                    // Jtl.g:1986:5: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_JTL_template_ObjectTemplateExp1688); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = JTL.template.TemplateFactory.eINSTANCE.createObjectTemplateExp();
                    						startIncompleteElement(element);
                    					}
                    					if (a4 != null) {
                    						JTL.resource.jtl.IJtlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    						tokenResolver.setOptions(getOptions());
                    						JTL.resource.jtl.IJtlTokenResolveResult result = getFreshTokenResolveResult();
                    						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS), result);
                    						Object resolvedObject = result.getResolvedToken();
                    						if (resolvedObject == null) {
                    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
                    						}
                    						java.lang.String resolved = (java.lang.String) resolvedObject;
                    						if (resolved != null) {
                    							Object value = resolved;
                    							element.eSet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS), value);
                    							completedElement(value, false);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_8_0_0_4_0_0_1, resolved, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[212]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[213]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[214]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[215]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[216]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[217]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[218]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[219]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[220]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[221]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[222]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[223]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[224]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[225]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[226]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[227]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[228]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[229]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[230]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[231]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[232]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[233]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[234]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[235]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[236]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[237]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[238]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[239]);
            	}

            // Jtl.g:2054:2: ( (a5= '{' ( ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* ) )? a9= '}' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==26) ) {
                int LA20_1 = input.LA(2);

                if ( (synpred21_Jtl()) ) {
                    alt20=1;
                }
            }
            switch (alt20) {
                case 1 :
                    // Jtl.g:2055:3: (a5= '{' ( ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* ) )? a9= '}' )
                    {
                    // Jtl.g:2055:3: (a5= '{' ( ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* ) )? a9= '}' )
                    // Jtl.g:2056:4: a5= '{' ( ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* ) )? a9= '}'
                    {
                    a5=(Token)match(input,26,FOLLOW_26_in_parse_JTL_template_ObjectTemplateExp1743); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = JTL.template.TemplateFactory.eINSTANCE.createObjectTemplateExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_8_0_0_5_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(JTL.template.TemplatePackage.eINSTANCE.getObjectTemplateExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[240]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[241]);
                    			}

                    // Jtl.g:2071:4: ( ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==TEXT) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // Jtl.g:2072:5: ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* )
                            {
                            // Jtl.g:2072:5: ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* )
                            // Jtl.g:2073:6: (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )*
                            {
                            // Jtl.g:2073:6: (a6_0= parse_JTL_imperativeocl_AssignExp )
                            // Jtl.g:2074:7: a6_0= parse_JTL_imperativeocl_AssignExp
                            {
                            pushFollow(FOLLOW_parse_JTL_imperativeocl_AssignExp_in_parse_JTL_template_ObjectTemplateExp1784);
                            a6_0=parse_JTL_imperativeocl_AssignExp();

                            state._fsp--;
                            if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (terminateParsing) {
                            								throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
                            							}
                            							if (element == null) {
                            								element = JTL.template.TemplateFactory.eINSTANCE.createObjectTemplateExp();
                            								startIncompleteElement(element);
                            							}
                            							if (a6_0 != null) {
                            								if (a6_0 != null) {
                            									Object value = a6_0;
                            									addObjectToList(element, JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__INSIDE, value);
                            									completedElement(value, true);
                            								}
                            								collectHiddenTokens(element);
                            								retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_8_0_0_5_0_0_2_0_0_1, a6_0, true);
                            								copyLocalizationInfos(a6_0, element);
                            							}
                            						}

                            }


                            if ( state.backtracking==0 ) {
                            						// expected elements (follow set)
                            						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[242]);
                            						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[243]);
                            					}

                            // Jtl.g:2100:6: ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )*
                            loop18:
                            do {
                                int alt18=2;
                                int LA18_0 = input.LA(1);

                                if ( (LA18_0==11) ) {
                                    alt18=1;
                                }


                                switch (alt18) {
                            	case 1 :
                            	    // Jtl.g:2101:7: (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) )
                            	    {
                            	    // Jtl.g:2101:7: (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) )
                            	    // Jtl.g:2102:8: a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp )
                            	    {
                            	    a7=(Token)match(input,11,FOLLOW_11_in_parse_JTL_template_ObjectTemplateExp1839); if (state.failed) return element;

                            	    if ( state.backtracking==0 ) {
                            	    								if (element == null) {
                            	    									element = JTL.template.TemplateFactory.eINSTANCE.createObjectTemplateExp();
                            	    									startIncompleteElement(element);
                            	    								}
                            	    								collectHiddenTokens(element);
                            	    								retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_8_0_0_5_0_0_2_0_0_2_0_0_0, null, true);
                            	    								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
                            	    							}

                            	    if ( state.backtracking==0 ) {
                            	    								// expected elements (follow set)
                            	    								addExpectedElement(JTL.template.TemplatePackage.eINSTANCE.getObjectTemplateExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[244]);
                            	    							}

                            	    // Jtl.g:2116:8: (a8_0= parse_JTL_imperativeocl_AssignExp )
                            	    // Jtl.g:2117:9: a8_0= parse_JTL_imperativeocl_AssignExp
                            	    {
                            	    pushFollow(FOLLOW_parse_JTL_imperativeocl_AssignExp_in_parse_JTL_template_ObjectTemplateExp1881);
                            	    a8_0=parse_JTL_imperativeocl_AssignExp();

                            	    state._fsp--;
                            	    if (state.failed) return element;

                            	    if ( state.backtracking==0 ) {
                            	    									if (terminateParsing) {
                            	    										throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
                            	    									}
                            	    									if (element == null) {
                            	    										element = JTL.template.TemplateFactory.eINSTANCE.createObjectTemplateExp();
                            	    										startIncompleteElement(element);
                            	    									}
                            	    									if (a8_0 != null) {
                            	    										if (a8_0 != null) {
                            	    											Object value = a8_0;
                            	    											addObjectToList(element, JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__INSIDE, value);
                            	    											completedElement(value, true);
                            	    										}
                            	    										collectHiddenTokens(element);
                            	    										retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_8_0_0_5_0_0_2_0_0_2_0_0_2, a8_0, true);
                            	    										copyLocalizationInfos(a8_0, element);
                            	    									}
                            	    								}

                            	    }


                            	    if ( state.backtracking==0 ) {
                            	    								// expected elements (follow set)
                            	    								addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[245]);
                            	    								addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[246]);
                            	    							}

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop18;
                                }
                            } while (true);


                            if ( state.backtracking==0 ) {
                            						// expected elements (follow set)
                            						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[247]);
                            						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[248]);
                            					}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[249]);
                    			}

                    a9=(Token)match(input,28,FOLLOW_28_in_parse_JTL_template_ObjectTemplateExp1985); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = JTL.template.TemplateFactory.eINSTANCE.createObjectTemplateExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_8_0_0_5_0_0_4, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[250]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[251]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[252]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[253]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[254]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[255]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[256]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[257]);
                    				addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[258]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[259]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[260]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[261]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[262]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[263]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[264]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[265]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[266]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[267]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[268]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[269]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[270]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[271]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[272]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[273]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[274]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[275]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parse_JTL_template_ObjectTemplateExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_template_ObjectTemplateExp"



    // $ANTLR start "parse_JTL_imperativeocl_AssignExp"
    // Jtl.g:2205:1: parse_JTL_imperativeocl_AssignExp returns [JTL.imperativeocl.AssignExp element = null] : (a0= TEXT ) a1= '=' ( (a2_0= parse_JTL_essentialocl_OclExpression ) )* ;
    public final JTL.imperativeocl.AssignExp parse_JTL_imperativeocl_AssignExp() throws RecognitionException {
        JTL.imperativeocl.AssignExp element =  null;

        int parse_JTL_imperativeocl_AssignExp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        JTL.essentialocl.OclExpression a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Jtl.g:2208:2: ( (a0= TEXT ) a1= '=' ( (a2_0= parse_JTL_essentialocl_OclExpression ) )* )
            // Jtl.g:2209:2: (a0= TEXT ) a1= '=' ( (a2_0= parse_JTL_essentialocl_OclExpression ) )*
            {
            // Jtl.g:2209:2: (a0= TEXT )
            // Jtl.g:2210:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_JTL_imperativeocl_AssignExp2037); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            			}
            			if (element == null) {
            				element = JTL.imperativeocl.ImperativeoclFactory.eINSTANCE.createAssignExp();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				JTL.resource.jtl.IJtlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				JTL.resource.jtl.IJtlTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_9_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[276]);
            	}

            a1=(Token)match(input,15,FOLLOW_15_in_parse_JTL_imperativeocl_AssignExp2058); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.imperativeocl.ImperativeoclFactory.eINSTANCE.createAssignExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_9_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[277]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[278]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[279]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[280]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[281]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[282]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[283]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[284]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[285]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[286]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[287]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[288]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[289]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[290]);
            	}

            // Jtl.g:2272:2: ( (a2_0= parse_JTL_essentialocl_OclExpression ) )*
            loop21:
            do {
                int alt21=2;
                switch ( input.LA(1) ) {
                case TEXT:
                    {
                    int LA21_2 = input.LA(2);

                    if ( (synpred22_Jtl()) ) {
                        alt21=1;
                    }


                    }
                    break;
                case 23:
                    {
                    int LA21_3 = input.LA(2);

                    if ( (synpred22_Jtl()) ) {
                        alt21=1;
                    }


                    }
                    break;
                case 19:
                    {
                    int LA21_4 = input.LA(2);

                    if ( (synpred22_Jtl()) ) {
                        alt21=1;
                    }


                    }
                    break;
                case 27:
                    {
                    int LA21_5 = input.LA(2);

                    if ( (synpred22_Jtl()) ) {
                        alt21=1;
                    }


                    }
                    break;

                }

                switch (alt21) {
            	case 1 :
            	    // Jtl.g:2273:3: (a2_0= parse_JTL_essentialocl_OclExpression )
            	    {
            	    // Jtl.g:2273:3: (a2_0= parse_JTL_essentialocl_OclExpression )
            	    // Jtl.g:2274:4: a2_0= parse_JTL_essentialocl_OclExpression
            	    {
            	    pushFollow(FOLLOW_parse_JTL_essentialocl_OclExpression_in_parse_JTL_imperativeocl_AssignExp2081);
            	    a2_0=parse_JTL_essentialocl_OclExpression();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = JTL.imperativeocl.ImperativeoclFactory.eINSTANCE.createAssignExp();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a2_0 != null) {
            	    					if (a2_0 != null) {
            	    						Object value = a2_0;
            	    						addObjectToList(element, JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__VALUE, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_9_0_0_4, a2_0, true);
            	    					copyLocalizationInfos(a2_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[291]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[292]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[293]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[294]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[295]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[296]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[297]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[298]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[299]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[300]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[301]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[302]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[303]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[304]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, parse_JTL_imperativeocl_AssignExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_imperativeocl_AssignExp"



    // $ANTLR start "parse_JTL_essentialocl_OperationCallExp"
    // Jtl.g:2315:1: parse_JTL_essentialocl_OperationCallExp returns [JTL.essentialocl.OperationCallExp element = null] : (a0= TEXT ) a1= '(' ( ( (a2_0= parse_JTL_essentialocl_OclExpression ) ( (a3= ',' (a4_0= parse_JTL_essentialocl_OclExpression ) ) )* ) )? a5= ')' ;
    public final JTL.essentialocl.OperationCallExp parse_JTL_essentialocl_OperationCallExp() throws RecognitionException {
        JTL.essentialocl.OperationCallExp element =  null;

        int parse_JTL_essentialocl_OperationCallExp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a5=null;
        JTL.essentialocl.OclExpression a2_0 =null;

        JTL.essentialocl.OclExpression a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Jtl.g:2318:2: ( (a0= TEXT ) a1= '(' ( ( (a2_0= parse_JTL_essentialocl_OclExpression ) ( (a3= ',' (a4_0= parse_JTL_essentialocl_OclExpression ) ) )* ) )? a5= ')' )
            // Jtl.g:2319:2: (a0= TEXT ) a1= '(' ( ( (a2_0= parse_JTL_essentialocl_OclExpression ) ( (a3= ',' (a4_0= parse_JTL_essentialocl_OclExpression ) ) )* ) )? a5= ')'
            {
            // Jtl.g:2319:2: (a0= TEXT )
            // Jtl.g:2320:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_JTL_essentialocl_OperationCallExp2126); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            			}
            			if (element == null) {
            				element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createOperationCallExp();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				JTL.resource.jtl.IJtlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				JTL.resource.jtl.IJtlTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_10_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[305]);
            	}

            a1=(Token)match(input,9,FOLLOW_9_in_parse_JTL_essentialocl_OperationCallExp2147); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createOperationCallExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_10_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[306]);
            		addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[307]);
            		addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[308]);
            		addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[309]);
            		addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[310]);
            		addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[311]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[312]);
            	}

            // Jtl.g:2375:2: ( ( (a2_0= parse_JTL_essentialocl_OclExpression ) ( (a3= ',' (a4_0= parse_JTL_essentialocl_OclExpression ) ) )* ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==TEXT||LA23_0==19||LA23_0==23||LA23_0==27) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // Jtl.g:2376:3: ( (a2_0= parse_JTL_essentialocl_OclExpression ) ( (a3= ',' (a4_0= parse_JTL_essentialocl_OclExpression ) ) )* )
                    {
                    // Jtl.g:2376:3: ( (a2_0= parse_JTL_essentialocl_OclExpression ) ( (a3= ',' (a4_0= parse_JTL_essentialocl_OclExpression ) ) )* )
                    // Jtl.g:2377:4: (a2_0= parse_JTL_essentialocl_OclExpression ) ( (a3= ',' (a4_0= parse_JTL_essentialocl_OclExpression ) ) )*
                    {
                    // Jtl.g:2377:4: (a2_0= parse_JTL_essentialocl_OclExpression )
                    // Jtl.g:2378:5: a2_0= parse_JTL_essentialocl_OclExpression
                    {
                    pushFollow(FOLLOW_parse_JTL_essentialocl_OclExpression_in_parse_JTL_essentialocl_OperationCallExp2176);
                    a2_0=parse_JTL_essentialocl_OclExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createOperationCallExp();
                    						startIncompleteElement(element);
                    					}
                    					if (a2_0 != null) {
                    						if (a2_0 != null) {
                    							Object value = a2_0;
                    							addObjectToList(element, JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__ARGUMENT, value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_10_0_0_2_0_0_0, a2_0, true);
                    						copyLocalizationInfos(a2_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[313]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[314]);
                    			}

                    // Jtl.g:2404:4: ( (a3= ',' (a4_0= parse_JTL_essentialocl_OclExpression ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==11) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // Jtl.g:2405:5: (a3= ',' (a4_0= parse_JTL_essentialocl_OclExpression ) )
                    	    {
                    	    // Jtl.g:2405:5: (a3= ',' (a4_0= parse_JTL_essentialocl_OclExpression ) )
                    	    // Jtl.g:2406:6: a3= ',' (a4_0= parse_JTL_essentialocl_OclExpression )
                    	    {
                    	    a3=(Token)match(input,11,FOLLOW_11_in_parse_JTL_essentialocl_OperationCallExp2217); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createOperationCallExp();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_10_0_0_2_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[315]);
                    	    						addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[316]);
                    	    						addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[317]);
                    	    						addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[318]);
                    	    						addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[319]);
                    	    						addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[320]);
                    	    					}

                    	    // Jtl.g:2425:6: (a4_0= parse_JTL_essentialocl_OclExpression )
                    	    // Jtl.g:2426:7: a4_0= parse_JTL_essentialocl_OclExpression
                    	    {
                    	    pushFollow(FOLLOW_parse_JTL_essentialocl_OclExpression_in_parse_JTL_essentialocl_OperationCallExp2251);
                    	    a4_0=parse_JTL_essentialocl_OclExpression();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    							if (terminateParsing) {
                    	    								throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
                    	    							}
                    	    							if (element == null) {
                    	    								element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createOperationCallExp();
                    	    								startIncompleteElement(element);
                    	    							}
                    	    							if (a4_0 != null) {
                    	    								if (a4_0 != null) {
                    	    									Object value = a4_0;
                    	    									addObjectToList(element, JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__ARGUMENT, value);
                    	    									completedElement(value, true);
                    	    								}
                    	    								collectHiddenTokens(element);
                    	    								retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_10_0_0_2_0_0_1_0_0_1, a4_0, true);
                    	    								copyLocalizationInfos(a4_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[321]);
                    	    						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[322]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[323]);
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[324]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[325]);
            	}

            a5=(Token)match(input,10,FOLLOW_10_in_parse_JTL_essentialocl_OperationCallExp2325); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createOperationCallExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_10_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[326]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[327]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[328]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[329]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[330]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[331]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[332]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[333]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[334]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[335]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[336]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[337]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[338]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[339]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, parse_JTL_essentialocl_OperationCallExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_essentialocl_OperationCallExp"



    // $ANTLR start "parse_JTL_essentialocl_BooleanLiteralExp"
    // Jtl.g:2496:1: parse_JTL_essentialocl_BooleanLiteralExp returns [JTL.essentialocl.BooleanLiteralExp element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final JTL.essentialocl.BooleanLiteralExp parse_JTL_essentialocl_BooleanLiteralExp() throws RecognitionException {
        JTL.essentialocl.BooleanLiteralExp element =  null;

        int parse_JTL_essentialocl_BooleanLiteralExp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Jtl.g:2499:2: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Jtl.g:2500:2: ( (a0= 'true' |a1= 'false' ) )
            {
            // Jtl.g:2500:2: ( (a0= 'true' |a1= 'false' ) )
            // Jtl.g:2501:3: (a0= 'true' |a1= 'false' )
            {
            // Jtl.g:2501:3: (a0= 'true' |a1= 'false' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==23) ) {
                alt24=1;
            }
            else if ( (LA24_0==19) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }
            switch (alt24) {
                case 1 :
                    // Jtl.g:2502:4: a0= 'true'
                    {
                    a0=(Token)match(input,23,FOLLOW_23_in_parse_JTL_essentialocl_BooleanLiteralExp2363); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createBooleanLiteralExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_11_0_0_0, true, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    				// set value of boolean attribute
                    				Object value = true;
                    				element.eSet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Jtl.g:2515:8: a1= 'false'
                    {
                    a1=(Token)match(input,19,FOLLOW_19_in_parse_JTL_essentialocl_BooleanLiteralExp2378); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createBooleanLiteralExp();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_11_0_0_0, false, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    				// set value of boolean attribute
                    				Object value = false;
                    				element.eSet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[340]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[341]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[342]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[343]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[344]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[345]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[346]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[347]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[348]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[349]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[350]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[351]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[352]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[353]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, parse_JTL_essentialocl_BooleanLiteralExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_essentialocl_BooleanLiteralExp"



    // $ANTLR start "parse_JTL_essentialocl_VariableExp"
    // Jtl.g:2550:1: parse_JTL_essentialocl_VariableExp returns [JTL.essentialocl.VariableExp element = null] : (a0= TEXT ) ;
    public final JTL.essentialocl.VariableExp parse_JTL_essentialocl_VariableExp() throws RecognitionException {
        JTL.essentialocl.VariableExp element =  null;

        int parse_JTL_essentialocl_VariableExp_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Jtl.g:2553:2: ( (a0= TEXT ) )
            // Jtl.g:2554:2: (a0= TEXT )
            {
            // Jtl.g:2554:2: (a0= TEXT )
            // Jtl.g:2555:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_JTL_essentialocl_VariableExp2418); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            			}
            			if (element == null) {
            				element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createVariableExp();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				JTL.resource.jtl.IJtlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				JTL.resource.jtl.IJtlTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE_EXP__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE_EXP__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_12_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[354]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[355]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[356]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[357]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[358]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[359]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[360]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[361]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[362]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[363]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[364]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[365]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[366]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[367]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, parse_JTL_essentialocl_VariableExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_essentialocl_VariableExp"



    // $ANTLR start "parse_JTL_essentialocl_StringLiteralExp"
    // Jtl.g:2605:1: parse_JTL_essentialocl_StringLiteralExp returns [JTL.essentialocl.StringLiteralExp element = null] : a0= '|' (a1= TEXT ) a2= '|' ;
    public final JTL.essentialocl.StringLiteralExp parse_JTL_essentialocl_StringLiteralExp() throws RecognitionException {
        JTL.essentialocl.StringLiteralExp element =  null;

        int parse_JTL_essentialocl_StringLiteralExp_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Jtl.g:2608:2: (a0= '|' (a1= TEXT ) a2= '|' )
            // Jtl.g:2609:2: a0= '|' (a1= TEXT ) a2= '|'
            {
            a0=(Token)match(input,27,FOLLOW_27_in_parse_JTL_essentialocl_StringLiteralExp2454); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createStringLiteralExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_13_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[368]);
            	}

            // Jtl.g:2623:2: (a1= TEXT )
            // Jtl.g:2624:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_JTL_essentialocl_StringLiteralExp2472); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            			}
            			if (element == null) {
            				element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createStringLiteralExp();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				JTL.resource.jtl.IJtlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				JTL.resource.jtl.IJtlTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.STRING_LITERAL_EXP__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.STRING_LITERAL_EXP__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_13_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[369]);
            	}

            a2=(Token)match(input,27,FOLLOW_27_in_parse_JTL_essentialocl_StringLiteralExp2493); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createStringLiteralExp();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_13_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[370]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[371]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[372]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[373]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[374]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[375]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[376]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[377]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[378]);
            		addExpectedElement(JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[379]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[380]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[381]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[382]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[383]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, parse_JTL_essentialocl_StringLiteralExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_essentialocl_StringLiteralExp"



    // $ANTLR start "parse_JTL_essentialocl_Variable"
    // Jtl.g:2688:1: parse_JTL_essentialocl_Variable returns [JTL.essentialocl.Variable element = null] : (a0= TEXT ) ( (a1= ':' (a2= TEXT ) ) )? a3= ';' ;
    public final JTL.essentialocl.Variable parse_JTL_essentialocl_Variable() throws RecognitionException {
        JTL.essentialocl.Variable element =  null;

        int parse_JTL_essentialocl_Variable_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Jtl.g:2691:2: ( (a0= TEXT ) ( (a1= ':' (a2= TEXT ) ) )? a3= ';' )
            // Jtl.g:2692:2: (a0= TEXT ) ( (a1= ':' (a2= TEXT ) ) )? a3= ';'
            {
            // Jtl.g:2692:2: (a0= TEXT )
            // Jtl.g:2693:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_JTL_essentialocl_Variable2526); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
            			}
            			if (element == null) {
            				element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createVariable();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				JTL.resource.jtl.IJtlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				JTL.resource.jtl.IJtlTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_14_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[384]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[385]);
            	}

            // Jtl.g:2729:2: ( (a1= ':' (a2= TEXT ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==12) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // Jtl.g:2730:3: (a1= ':' (a2= TEXT ) )
                    {
                    // Jtl.g:2730:3: (a1= ':' (a2= TEXT ) )
                    // Jtl.g:2731:4: a1= ':' (a2= TEXT )
                    {
                    a1=(Token)match(input,12,FOLLOW_12_in_parse_JTL_essentialocl_Variable2556); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createVariable();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_14_0_0_1_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[386]);
                    			}

                    // Jtl.g:2745:4: (a2= TEXT )
                    // Jtl.g:2746:5: a2= TEXT
                    {
                    a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_JTL_essentialocl_Variable2582); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new JTL.resource.jtl.mopp.JtlTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createVariable();
                    						startIncompleteElement(element);
                    					}
                    					if (a2 != null) {
                    						JTL.resource.jtl.IJtlTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    						tokenResolver.setOptions(getOptions());
                    						JTL.resource.jtl.IJtlTokenResolveResult result = getFreshTokenResolveResult();
                    						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__TYPE), result);
                    						Object resolvedObject = result.getResolvedToken();
                    						if (resolvedObject == null) {
                    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
                    						}
                    						java.lang.String resolved = (java.lang.String) resolvedObject;
                    						if (resolved != null) {
                    							Object value = resolved;
                    							element.eSet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__TYPE), value);
                    							completedElement(value, false);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_14_0_0_1_0_0_3, resolved, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[387]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[388]);
            	}

            a3=(Token)match(input,14,FOLLOW_14_in_parse_JTL_essentialocl_Variable2628); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createVariable();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_14_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[389]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[390]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[391]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[392]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[393]);
            		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[394]);
            		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[395]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, parse_JTL_essentialocl_Variable_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_essentialocl_Variable"



    // $ANTLR start "parse_JTL_template_TemplateExp"
    // Jtl.g:2810:1: parse_JTL_template_TemplateExp returns [JTL.template.TemplateExp element = null] : c0= parse_JTL_template_ObjectTemplateExp ;
    public final JTL.template.TemplateExp parse_JTL_template_TemplateExp() throws RecognitionException {
        JTL.template.TemplateExp element =  null;

        int parse_JTL_template_TemplateExp_StartIndex = input.index();

        JTL.template.ObjectTemplateExp c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Jtl.g:2811:2: (c0= parse_JTL_template_ObjectTemplateExp )
            // Jtl.g:2812:2: c0= parse_JTL_template_ObjectTemplateExp
            {
            pushFollow(FOLLOW_parse_JTL_template_ObjectTemplateExp_in_parse_JTL_template_TemplateExp2653);
            c0=parse_JTL_template_ObjectTemplateExp();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, parse_JTL_template_TemplateExp_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_template_TemplateExp"



    // $ANTLR start "parse_JTL_essentialocl_OclExpression"
    // Jtl.g:2816:1: parse_JTL_essentialocl_OclExpression returns [JTL.essentialocl.OclExpression element = null] : (c0= parse_JTL_template_ObjectTemplateExp |c1= parse_JTL_imperativeocl_AssignExp |c2= parse_JTL_essentialocl_OperationCallExp |c3= parse_JTL_essentialocl_BooleanLiteralExp |c4= parse_JTL_essentialocl_VariableExp |c5= parse_JTL_essentialocl_StringLiteralExp );
    public final JTL.essentialocl.OclExpression parse_JTL_essentialocl_OclExpression() throws RecognitionException {
        JTL.essentialocl.OclExpression element =  null;

        int parse_JTL_essentialocl_OclExpression_StartIndex = input.index();

        JTL.template.ObjectTemplateExp c0 =null;

        JTL.imperativeocl.AssignExp c1 =null;

        JTL.essentialocl.OperationCallExp c2 =null;

        JTL.essentialocl.BooleanLiteralExp c3 =null;

        JTL.essentialocl.VariableExp c4 =null;

        JTL.essentialocl.StringLiteralExp c5 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Jtl.g:2817:2: (c0= parse_JTL_template_ObjectTemplateExp |c1= parse_JTL_imperativeocl_AssignExp |c2= parse_JTL_essentialocl_OperationCallExp |c3= parse_JTL_essentialocl_BooleanLiteralExp |c4= parse_JTL_essentialocl_VariableExp |c5= parse_JTL_essentialocl_StringLiteralExp )
            int alt26=6;
            switch ( input.LA(1) ) {
            case TEXT:
                {
                switch ( input.LA(2) ) {
                case 12:
                    {
                    alt26=1;
                    }
                    break;
                case 15:
                    {
                    alt26=2;
                    }
                    break;
                case 9:
                    {
                    alt26=3;
                    }
                    break;
                case EOF:
                case TEXT:
                case 10:
                case 11:
                case 14:
                case 19:
                case 23:
                case 27:
                case 28:
                case 29:
                    {
                    alt26=5;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;

                }

                }
                break;
            case 19:
            case 23:
                {
                alt26=4;
                }
                break;
            case 27:
                {
                alt26=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }

            switch (alt26) {
                case 1 :
                    // Jtl.g:2818:2: c0= parse_JTL_template_ObjectTemplateExp
                    {
                    pushFollow(FOLLOW_parse_JTL_template_ObjectTemplateExp_in_parse_JTL_essentialocl_OclExpression2674);
                    c0=parse_JTL_template_ObjectTemplateExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Jtl.g:2819:4: c1= parse_JTL_imperativeocl_AssignExp
                    {
                    pushFollow(FOLLOW_parse_JTL_imperativeocl_AssignExp_in_parse_JTL_essentialocl_OclExpression2684);
                    c1=parse_JTL_imperativeocl_AssignExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Jtl.g:2820:4: c2= parse_JTL_essentialocl_OperationCallExp
                    {
                    pushFollow(FOLLOW_parse_JTL_essentialocl_OperationCallExp_in_parse_JTL_essentialocl_OclExpression2694);
                    c2=parse_JTL_essentialocl_OperationCallExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Jtl.g:2821:4: c3= parse_JTL_essentialocl_BooleanLiteralExp
                    {
                    pushFollow(FOLLOW_parse_JTL_essentialocl_BooleanLiteralExp_in_parse_JTL_essentialocl_OclExpression2704);
                    c3=parse_JTL_essentialocl_BooleanLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Jtl.g:2822:4: c4= parse_JTL_essentialocl_VariableExp
                    {
                    pushFollow(FOLLOW_parse_JTL_essentialocl_VariableExp_in_parse_JTL_essentialocl_OclExpression2714);
                    c4=parse_JTL_essentialocl_VariableExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Jtl.g:2823:4: c5= parse_JTL_essentialocl_StringLiteralExp
                    {
                    pushFollow(FOLLOW_parse_JTL_essentialocl_StringLiteralExp_in_parse_JTL_essentialocl_OclExpression2724);
                    c5=parse_JTL_essentialocl_StringLiteralExp();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 18, parse_JTL_essentialocl_OclExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_JTL_essentialocl_OclExpression"

    // $ANTLR start synpred17_Jtl
    public final void synpred17_Jtl_fragment() throws RecognitionException {
        Token a2=null;

        // Jtl.g:1897:3: ( ( (a2= TEXT ) ) )
        // Jtl.g:1897:3: ( (a2= TEXT ) )
        {
        // Jtl.g:1897:3: ( (a2= TEXT ) )
        // Jtl.g:1898:4: (a2= TEXT )
        {
        // Jtl.g:1898:4: (a2= TEXT )
        // Jtl.g:1899:5: a2= TEXT
        {
        a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_synpred17_Jtl1607); if (state.failed) return ;

        }


        }


        }

    }
    // $ANTLR end synpred17_Jtl

    // $ANTLR start synpred21_Jtl
    public final void synpred21_Jtl_fragment() throws RecognitionException {
        Token a5=null;
        Token a7=null;
        Token a9=null;
        JTL.imperativeocl.AssignExp a6_0 =null;

        JTL.imperativeocl.AssignExp a8_0 =null;


        // Jtl.g:2055:3: ( (a5= '{' ( ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* ) )? a9= '}' ) )
        // Jtl.g:2055:3: (a5= '{' ( ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* ) )? a9= '}' )
        {
        // Jtl.g:2055:3: (a5= '{' ( ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* ) )? a9= '}' )
        // Jtl.g:2056:4: a5= '{' ( ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* ) )? a9= '}'
        {
        a5=(Token)match(input,26,FOLLOW_26_in_synpred21_Jtl1743); if (state.failed) return ;

        // Jtl.g:2071:4: ( ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* ) )?
        int alt33=2;
        int LA33_0 = input.LA(1);

        if ( (LA33_0==TEXT) ) {
            alt33=1;
        }
        switch (alt33) {
            case 1 :
                // Jtl.g:2072:5: ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* )
                {
                // Jtl.g:2072:5: ( (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )* )
                // Jtl.g:2073:6: (a6_0= parse_JTL_imperativeocl_AssignExp ) ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )*
                {
                // Jtl.g:2073:6: (a6_0= parse_JTL_imperativeocl_AssignExp )
                // Jtl.g:2074:7: a6_0= parse_JTL_imperativeocl_AssignExp
                {
                pushFollow(FOLLOW_parse_JTL_imperativeocl_AssignExp_in_synpred21_Jtl1784);
                a6_0=parse_JTL_imperativeocl_AssignExp();

                state._fsp--;
                if (state.failed) return ;

                }


                // Jtl.g:2100:6: ( (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) ) )*
                loop32:
                do {
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==11) ) {
                        alt32=1;
                    }


                    switch (alt32) {
                	case 1 :
                	    // Jtl.g:2101:7: (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) )
                	    {
                	    // Jtl.g:2101:7: (a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp ) )
                	    // Jtl.g:2102:8: a7= ',' (a8_0= parse_JTL_imperativeocl_AssignExp )
                	    {
                	    a7=(Token)match(input,11,FOLLOW_11_in_synpred21_Jtl1839); if (state.failed) return ;

                	    // Jtl.g:2116:8: (a8_0= parse_JTL_imperativeocl_AssignExp )
                	    // Jtl.g:2117:9: a8_0= parse_JTL_imperativeocl_AssignExp
                	    {
                	    pushFollow(FOLLOW_parse_JTL_imperativeocl_AssignExp_in_synpred21_Jtl1881);
                	    a8_0=parse_JTL_imperativeocl_AssignExp();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop32;
                    }
                } while (true);


                }


                }
                break;

        }


        a9=(Token)match(input,28,FOLLOW_28_in_synpred21_Jtl1985); if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred21_Jtl

    // $ANTLR start synpred22_Jtl
    public final void synpred22_Jtl_fragment() throws RecognitionException {
        JTL.essentialocl.OclExpression a2_0 =null;


        // Jtl.g:2273:3: ( (a2_0= parse_JTL_essentialocl_OclExpression ) )
        // Jtl.g:2273:3: (a2_0= parse_JTL_essentialocl_OclExpression )
        {
        // Jtl.g:2273:3: (a2_0= parse_JTL_essentialocl_OclExpression )
        // Jtl.g:2274:4: a2_0= parse_JTL_essentialocl_OclExpression
        {
        pushFollow(FOLLOW_parse_JTL_essentialocl_OclExpression_in_synpred22_Jtl2081);
        a2_0=parse_JTL_essentialocl_OclExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred22_Jtl

    // Delegated rules

    public final boolean synpred21_Jtl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_Jtl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_Jtl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_Jtl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_Jtl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_Jtl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_parse_JTL_JTL_Transformation_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_parse_JTL_JTL_Transformation115 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEXT_in_parse_JTL_JTL_Transformation133 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_JTL_JTL_Transformation154 = new BitSet(new long[]{0x0000000000000480L});
    public static final BitSet FOLLOW_parse_JTL_JTL_Model_in_parse_JTL_JTL_Transformation183 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_11_in_parse_JTL_JTL_Transformation224 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_JTL_JTL_Model_in_parse_JTL_JTL_Transformation258 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_10_in_parse_JTL_JTL_Transformation332 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_JTL_JTL_Transformation346 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_parse_JTL_JTL_Relation_in_parse_JTL_JTL_Transformation375 = new BitSet(new long[]{0x0000000010300000L});
    public static final BitSet FOLLOW_28_in_parse_JTL_JTL_Transformation416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_JTL_JTL_Model449 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_JTL_JTL_Model470 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEXT_in_parse_JTL_JTL_Model488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_JTL_JTL_Relation533 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_JTL_JTL_Relation554 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEXT_in_parse_JTL_JTL_Relation572 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_JTL_JTL_Relation593 = new BitSet(new long[]{0x0000000013070080L});
    public static final BitSet FOLLOW_parse_JTL_essentialocl_Variable_in_parse_JTL_JTL_Relation622 = new BitSet(new long[]{0x0000000013070080L});
    public static final BitSet FOLLOW_parse_JTL_JTL_Domain_in_parse_JTL_JTL_Relation678 = new BitSet(new long[]{0x0000000013070000L});
    public static final BitSet FOLLOW_parse_JTL_JTL_When_in_parse_JTL_JTL_Relation734 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_parse_JTL_JTL_Where_in_parse_JTL_JTL_Relation790 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_parse_JTL_JTL_Relation831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_JTL_JTL_Domain869 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_parse_JTL_JTL_Domain899 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_JTL_JTL_Domain920 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEXT_in_parse_JTL_JTL_Domain938 = new BitSet(new long[]{0x0000000003000080L});
    public static final BitSet FOLLOW_parse_JTL_JTL_Pattern_in_parse_JTL_JTL_Domain963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_JTL_template_TemplateExp_in_parse_JTL_JTL_Pattern1000 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_JTL_JTL_Pattern1018 = new BitSet(new long[]{0x0000000028880080L});
    public static final BitSet FOLLOW_parse_JTL_JTL_Predicate_in_parse_JTL_JTL_Pattern1047 = new BitSet(new long[]{0x0000000020000800L});
    public static final BitSet FOLLOW_11_in_parse_JTL_JTL_Pattern1088 = new BitSet(new long[]{0x0000000008880080L});
    public static final BitSet FOLLOW_parse_JTL_JTL_Predicate_in_parse_JTL_JTL_Pattern1122 = new BitSet(new long[]{0x0000000020000800L});
    public static final BitSet FOLLOW_29_in_parse_JTL_JTL_Pattern1196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_JTL_JTL_When_in_parse_JTL_JTL_Pattern1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_JTL_JTL_Where_in_parse_JTL_JTL_Pattern1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_parse_JTL_JTL_When1250 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_JTL_JTL_When1264 = new BitSet(new long[]{0x0000000018880080L});
    public static final BitSet FOLLOW_parse_JTL_JTL_Predicate_in_parse_JTL_JTL_When1293 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_JTL_JTL_When1321 = new BitSet(new long[]{0x0000000018880080L});
    public static final BitSet FOLLOW_28_in_parse_JTL_JTL_When1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_parse_JTL_JTL_Where1383 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_JTL_JTL_Where1397 = new BitSet(new long[]{0x0000000018880080L});
    public static final BitSet FOLLOW_parse_JTL_JTL_Predicate_in_parse_JTL_JTL_Where1426 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_JTL_JTL_Where1454 = new BitSet(new long[]{0x0000000018880080L});
    public static final BitSet FOLLOW_28_in_parse_JTL_JTL_Where1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_JTL_essentialocl_OclExpression_in_parse_JTL_JTL_Predicate1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_JTL_template_ObjectTemplateExp1557 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_JTL_template_ObjectTemplateExp1578 = new BitSet(new long[]{0x0000000004002082L});
    public static final BitSet FOLLOW_TEXT_in_parse_JTL_template_ObjectTemplateExp1607 = new BitSet(new long[]{0x0000000004002002L});
    public static final BitSet FOLLOW_13_in_parse_JTL_template_ObjectTemplateExp1662 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEXT_in_parse_JTL_template_ObjectTemplateExp1688 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_parse_JTL_template_ObjectTemplateExp1743 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_parse_JTL_imperativeocl_AssignExp_in_parse_JTL_template_ObjectTemplateExp1784 = new BitSet(new long[]{0x0000000010000800L});
    public static final BitSet FOLLOW_11_in_parse_JTL_template_ObjectTemplateExp1839 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_JTL_imperativeocl_AssignExp_in_parse_JTL_template_ObjectTemplateExp1881 = new BitSet(new long[]{0x0000000010000800L});
    public static final BitSet FOLLOW_28_in_parse_JTL_template_ObjectTemplateExp1985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_JTL_imperativeocl_AssignExp2037 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_JTL_imperativeocl_AssignExp2058 = new BitSet(new long[]{0x0000000008880082L});
    public static final BitSet FOLLOW_parse_JTL_essentialocl_OclExpression_in_parse_JTL_imperativeocl_AssignExp2081 = new BitSet(new long[]{0x0000000008880082L});
    public static final BitSet FOLLOW_TEXT_in_parse_JTL_essentialocl_OperationCallExp2126 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_JTL_essentialocl_OperationCallExp2147 = new BitSet(new long[]{0x0000000008880480L});
    public static final BitSet FOLLOW_parse_JTL_essentialocl_OclExpression_in_parse_JTL_essentialocl_OperationCallExp2176 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_11_in_parse_JTL_essentialocl_OperationCallExp2217 = new BitSet(new long[]{0x0000000008880080L});
    public static final BitSet FOLLOW_parse_JTL_essentialocl_OclExpression_in_parse_JTL_essentialocl_OperationCallExp2251 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_10_in_parse_JTL_essentialocl_OperationCallExp2325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_JTL_essentialocl_BooleanLiteralExp2363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_parse_JTL_essentialocl_BooleanLiteralExp2378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_JTL_essentialocl_VariableExp2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_parse_JTL_essentialocl_StringLiteralExp2454 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEXT_in_parse_JTL_essentialocl_StringLiteralExp2472 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_JTL_essentialocl_StringLiteralExp2493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_JTL_essentialocl_Variable2526 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_12_in_parse_JTL_essentialocl_Variable2556 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEXT_in_parse_JTL_essentialocl_Variable2582 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_JTL_essentialocl_Variable2628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_JTL_template_ObjectTemplateExp_in_parse_JTL_template_TemplateExp2653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_JTL_template_ObjectTemplateExp_in_parse_JTL_essentialocl_OclExpression2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_JTL_imperativeocl_AssignExp_in_parse_JTL_essentialocl_OclExpression2684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_JTL_essentialocl_OperationCallExp_in_parse_JTL_essentialocl_OclExpression2694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_JTL_essentialocl_BooleanLiteralExp_in_parse_JTL_essentialocl_OclExpression2704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_JTL_essentialocl_VariableExp_in_parse_JTL_essentialocl_OclExpression2714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_JTL_essentialocl_StringLiteralExp_in_parse_JTL_essentialocl_OclExpression2724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_synpred17_Jtl1607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_synpred21_Jtl1743 = new BitSet(new long[]{0x0000000010000080L});
    public static final BitSet FOLLOW_parse_JTL_imperativeocl_AssignExp_in_synpred21_Jtl1784 = new BitSet(new long[]{0x0000000010000800L});
    public static final BitSet FOLLOW_11_in_synpred21_Jtl1839 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_JTL_imperativeocl_AssignExp_in_synpred21_Jtl1881 = new BitSet(new long[]{0x0000000010000800L});
    public static final BitSet FOLLOW_28_in_synpred21_Jtl1985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_JTL_essentialocl_OclExpression_in_synpred22_Jtl2081 = new BitSet(new long[]{0x0000000000000002L});

}