grammar Jtl;

options {
	superClass = JtlANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package JTL.resource.jtl.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
	}
}
@header{
	package JTL.resource.jtl.mopp;
}

@members{
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_JTL_JTL_Transformation{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_JTL_JTL_Transformation returns [JTL.JTL.Transformation element = null]
@init{
}
:
	a0 = 'transformation' {
		if (element == null) {
			element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[1]);
	}
	
	(
		a1 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[2]);
	}
	
	a2 = '(' {
		if (element == null) {
			element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[3]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[4]);
	}
	
	(
		(
			(
				a3_0 = parse_JTL_JTL_Model				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[5]);
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[6]);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_4_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[7]);
					}
					
					(
						a5_0 = parse_JTL_JTL_Model						{
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
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[8]);
						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[9]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[10]);
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[11]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[12]);
	}
	
	a6 = ')' {
		if (element == null) {
			element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[13]);
	}
	
	a7 = '{' {
		if (element == null) {
			element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[14]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[15]);
	}
	
	(
		(
			(
				a8_0 = parse_JTL_JTL_Relation				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[16]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[17]);
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[18]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[19]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[20]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[21]);
	}
	
	a9 = '}' {
		if (element == null) {
			element = JTL.JTL.JTLFactory.eINSTANCE.createTransformation();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_0_0_0_10, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
	}
	
;

parse_JTL_JTL_Model returns [JTL.JTL.Model element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[22]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = JTL.JTL.JTLFactory.eINSTANCE.createModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_1_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[23]);
	}
	
	(
		a2 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[24]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[25]);
	}
	
;

parse_JTL_JTL_Relation returns [JTL.JTL.Relation element = null]
@init{
}
:
	(
		(
			a0 = 'top' {
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
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[26]);
	}
	
	a3 = 'relation' {
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
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[27]);
	}
	
	(
		a4 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[28]);
	}
	
	a5 = '{' {
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
	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[29]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[30]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[31]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[32]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[33]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[34]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[35]);
	}
	
	(
		(
			(
				a6_0 = parse_JTL_essentialocl_Variable				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[36]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[37]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[38]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[39]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[40]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[41]);
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[42]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[43]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[44]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[45]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[46]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[47]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[48]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[49]);
	}
	
	(
		(
			(
				a7_0 = parse_JTL_JTL_Domain				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[50]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[51]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[52]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[53]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[54]);
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[55]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[56]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[57]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[58]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[59]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[60]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[61]);
	}
	
	(
		(
			(
				a8_0 = parse_JTL_JTL_When				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[62]);
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[63]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[64]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[65]);
	}
	
	(
		(
			(
				a9_0 = parse_JTL_JTL_Where				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[66]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[67]);
	}
	
	a10 = '}' {
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
	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[68]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getTransformation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[69]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[70]);
	}
	
;

parse_JTL_JTL_Domain returns [JTL.JTL.Domain element = null]
@init{
}
:
	(
		(
			a0 = 'checkonly' {
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
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[71]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[72]);
	}
	
	(
		(
			a3 = 'enforce' {
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
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[73]);
	}
	
	a6 = 'domain' {
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
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[74]);
	}
	
	(
		a7 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getDomain(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[75]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getDomain(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[76]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getDomain(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[77]);
	}
	
	(
		a8_0 = parse_JTL_JTL_Pattern		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[78]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[79]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[80]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[81]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[82]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[83]);
	}
	
;

parse_JTL_JTL_Pattern returns [JTL.JTL.Pattern element = null]
@init{
}
:
	(
		a0_0 = parse_JTL_template_TemplateExp		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[84]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = JTL.JTL.JTLFactory.eINSTANCE.createPattern();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_4_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[85]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[86]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[87]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[88]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[89]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[90]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[91]);
	}
	
	(
		(
			(
				a2_0 = parse_JTL_JTL_Predicate				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[92]);
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[93]);
			}
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = JTL.JTL.JTLFactory.eINSTANCE.createPattern();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_4_0_0_3_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[94]);
						addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[95]);
						addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[96]);
						addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[97]);
						addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[98]);
						addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getPattern(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[99]);
					}
					
					(
						a4_0 = parse_JTL_JTL_Predicate						{
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
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[100]);
						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[101]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[102]);
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[103]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[104]);
	}
	
	a5 = '};' {
		if (element == null) {
			element = JTL.JTL.JTLFactory.eINSTANCE.createPattern();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_4_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[105]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[106]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[107]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[108]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[109]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[110]);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_JTL_JTL_When{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_JTL_JTL_Where{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_JTL_JTL_When returns [JTL.JTL.When element = null]
@init{
}
:
	a0 = 'when' {
		if (element == null) {
			element = JTL.JTL.JTLFactory.eINSTANCE.createWhen();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_5_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[111]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = JTL.JTL.JTLFactory.eINSTANCE.createWhen();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_5_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[112]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[113]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[114]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[115]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[116]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[117]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[118]);
	}
	
	(
		(
			(
				a2_0 = parse_JTL_JTL_Predicate				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[119]);
			}
			
			a3 = ';' {
				if (element == null) {
					element = JTL.JTL.JTLFactory.eINSTANCE.createWhen();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_5_0_0_3_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[120]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[121]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[122]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[123]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[124]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[125]);
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[126]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[127]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[128]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[129]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[130]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[131]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhen(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[132]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[133]);
	}
	
	a4 = '}' {
		if (element == null) {
			element = JTL.JTL.JTLFactory.eINSTANCE.createWhen();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_5_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[134]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[135]);
	}
	
;

parse_JTL_JTL_Where returns [JTL.JTL.Where element = null]
@init{
}
:
	a0 = 'where' {
		if (element == null) {
			element = JTL.JTL.JTLFactory.eINSTANCE.createWhere();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_6_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[136]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = JTL.JTL.JTLFactory.eINSTANCE.createWhere();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_6_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[137]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[138]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[139]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[140]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[141]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[142]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[143]);
	}
	
	(
		(
			(
				a2_0 = parse_JTL_JTL_Predicate				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[144]);
			}
			
			a3 = ';' {
				if (element == null) {
					element = JTL.JTL.JTLFactory.eINSTANCE.createWhere();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_6_0_0_3_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[145]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[146]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[147]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[148]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[149]);
				addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[150]);
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[151]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[152]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[153]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[154]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[155]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[156]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getWhere(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[157]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[158]);
	}
	
	a4 = '}' {
		if (element == null) {
			element = JTL.JTL.JTLFactory.eINSTANCE.createWhere();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_6_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[159]);
	}
	
;

parse_JTL_JTL_Predicate returns [JTL.JTL.Predicate element = null]
@init{
}
:
	(
		a0_0 = parse_JTL_essentialocl_OclExpression		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[160]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[161]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[162]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[163]);
	}
	
;

parse_JTL_template_ObjectTemplateExp returns [JTL.template.ObjectTemplateExp element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[164]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = JTL.template.TemplateFactory.eINSTANCE.createObjectTemplateExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_8_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
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
	
	(
		(
			(
				a2 = TEXT				
				{
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
			)
			{
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
			
		)
		
	)?	{
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
	
	(
		(
			a3 = '::' {
				if (element == null) {
					element = JTL.template.TemplateFactory.eINSTANCE.createObjectTemplateExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_8_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[211]);
			}
			
			(
				a4 = TEXT				
				{
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
			)
			{
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
			
		)
		
	)?	{
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
	
	(
		(
			a5 = '{' {
				if (element == null) {
					element = JTL.template.TemplateFactory.eINSTANCE.createObjectTemplateExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_8_0_0_5_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(JTL.template.TemplatePackage.eINSTANCE.getObjectTemplateExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[240]);
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[241]);
			}
			
			(
				(
					(
						a6_0 = parse_JTL_imperativeocl_AssignExp						{
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
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[242]);
						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[243]);
					}
					
					(
						(
							a7 = ',' {
								if (element == null) {
									element = JTL.template.TemplateFactory.eINSTANCE.createObjectTemplateExp();
									startIncompleteElement(element);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_8_0_0_5_0_0_2_0_0_2_0_0_0, null, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
							}
							{
								// expected elements (follow set)
								addExpectedElement(JTL.template.TemplatePackage.eINSTANCE.getObjectTemplateExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[244]);
							}
							
							(
								a8_0 = parse_JTL_imperativeocl_AssignExp								{
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
							)
							{
								// expected elements (follow set)
								addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[245]);
								addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[246]);
							}
							
						)
						
					)*					{
						// expected elements (follow set)
						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[247]);
						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[248]);
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[249]);
			}
			
			a9 = '}' {
				if (element == null) {
					element = JTL.template.TemplateFactory.eINSTANCE.createObjectTemplateExp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_8_0_0_5_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
			}
			{
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
			
		)
		
	)?	{
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
	
;

parse_JTL_imperativeocl_AssignExp returns [JTL.imperativeocl.AssignExp element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[276]);
	}
	
	a1 = '=' {
		if (element == null) {
			element = JTL.imperativeocl.ImperativeoclFactory.eINSTANCE.createAssignExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_9_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
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
	
	(
		(
			a2_0 = parse_JTL_essentialocl_OclExpression			{
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
		)
		
	)*	{
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
	
;

parse_JTL_essentialocl_OperationCallExp returns [JTL.essentialocl.OperationCallExp element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[305]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createOperationCallExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_10_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[306]);
		addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[307]);
		addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[308]);
		addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[309]);
		addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[310]);
		addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[311]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[312]);
	}
	
	(
		(
			(
				a2_0 = parse_JTL_essentialocl_OclExpression				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[313]);
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[314]);
			}
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createOperationCallExp();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_10_0_0_2_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[315]);
						addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[316]);
						addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[317]);
						addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[318]);
						addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[319]);
						addExpectedElement(JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[320]);
					}
					
					(
						a4_0 = parse_JTL_essentialocl_OclExpression						{
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
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[321]);
						addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[322]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[323]);
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[324]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[325]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createOperationCallExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_10_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
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
	
;

parse_JTL_essentialocl_BooleanLiteralExp returns [JTL.essentialocl.BooleanLiteralExp element = null]
@init{
}
:
	(
		(
			a0 = 'true' {
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
			|			a1 = 'false' {
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
		)
	)
	{
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
	
;

parse_JTL_essentialocl_VariableExp returns [JTL.essentialocl.VariableExp element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
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
	)
	{
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
	
;

parse_JTL_essentialocl_StringLiteralExp returns [JTL.essentialocl.StringLiteralExp element = null]
@init{
}
:
	a0 = '|' {
		if (element == null) {
			element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createStringLiteralExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_13_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[368]);
	}
	
	(
		a1 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[369]);
	}
	
	a2 = '|' {
		if (element == null) {
			element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createStringLiteralExp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_13_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
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
	
;

parse_JTL_essentialocl_Variable returns [JTL.essentialocl.Variable element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[384]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[385]);
	}
	
	(
		(
			a1 = ':' {
				if (element == null) {
					element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createVariable();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_14_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[386]);
			}
			
			(
				a2 = TEXT				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[387]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[388]);
	}
	
	a3 = ';' {
		if (element == null) {
			element = JTL.essentialocl.EssentialoclFactory.eINSTANCE.createVariable();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, JTL.resource.jtl.grammar.JtlGrammarInformationProvider.JTL_14_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[389]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[390]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[391]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[392]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[393]);
		addExpectedElement(JTL.JTL.JTLPackage.eINSTANCE.getRelation(), JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[394]);
		addExpectedElement(null, JTL.resource.jtl.mopp.JtlExpectationConstants.EXPECTATIONS[395]);
	}
	
;

parse_JTL_template_TemplateExp returns [JTL.template.TemplateExp element = null]
:
	c0 = parse_JTL_template_ObjectTemplateExp{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_JTL_essentialocl_OclExpression returns [JTL.essentialocl.OclExpression element = null]
:
	c0 = parse_JTL_template_ObjectTemplateExp{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_JTL_imperativeocl_AssignExp{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_JTL_essentialocl_OperationCallExp{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_JTL_essentialocl_BooleanLiteralExp{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_JTL_essentialocl_VariableExp{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_JTL_essentialocl_StringLiteralExp{ element = c5; /* this is a subclass or primitive expression choice */ }
	
;

SL_COMMENT:
	(('//'|'--')(~('\n'|'\r'|'\uffff'))* )
	{ _channel = 99; }
;
ML_COMMENT:
	('/*'.*'*/')
	{ _channel = 99; }
;
TEXT:
	(('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+)
;
WHITESPACE:
	((' ' | '\t' | '\f'))
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;

