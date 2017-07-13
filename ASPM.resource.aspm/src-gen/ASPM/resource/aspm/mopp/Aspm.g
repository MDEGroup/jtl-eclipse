grammar Aspm;

options {
	superClass = AspmANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package ASPM.resource.aspm.mopp;
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
	package ASPM.resource.aspm.mopp;
}

@members{
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_ASPM_Model{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_ASPM_Model returns [ASPM.Model element = null]
@init{
}
:
	a0 = 'model' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[1]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[2]);
	}
	
	(
		a2 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[3]);
	}
	
	a3 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[4]);
	}
	
	(
		a4 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[5]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[6]);
	}
	
	a6 = '.' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_0_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[7]);
		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[8]);
		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[9]);
	}
	
	(
		(
			a7_0 = parse_ASPM_Node			{
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
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[10]);
		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[11]);
		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[12]);
	}
	
	(
		(
			a8_0 = parse_ASPM_Prop			{
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
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[13]);
		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[14]);
	}
	
	(
		(
			a9_0 = parse_ASPM_Edge			{
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
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[15]);
	}
	
;

parse_ASPM_Node returns [ASPM.Node element = null]
@init{
}
:
	a0 = 'node' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[16]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[17]);
	}
	
	(
		a2 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[18]);
	}
	
	a3 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[19]);
	}
	
	(
		a4 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[20]);
	}
	
	a5 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[21]);
	}
	
	(
		a6 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[22]);
	}
	
	a7 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[23]);
	}
	
	(
		a8 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[24]);
	}
	
	a9 = ')' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[25]);
	}
	
	a10 = '.' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_1_0_0_10, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[26]);
		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[28]);
	}
	
;

parse_ASPM_Prop returns [ASPM.Prop element = null]
@init{
}
:
	a0 = 'prop' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[29]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[30]);
	}
	
	(
		a2 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[31]);
	}
	
	a3 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[32]);
	}
	
	(
		a4 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[33]);
	}
	
	a5 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[34]);
	}
	
	(
		a6 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[35]);
	}
	
	a7 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[36]);
	}
	
	(
		a8 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[37]);
	}
	
	a9 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[38]);
	}
	
	(
		a10 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[39]);
	}
	
	a11 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_11, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[40]);
	}
	
	(
		a12 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[41]);
	}
	
	a13 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_13, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[42]);
	}
	
	(
		a14 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[43]);
	}
	
	a15 = ')' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_15, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[44]);
	}
	
	a16 = '.' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_2_0_0_16, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[45]);
		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[46]);
	}
	
;

parse_ASPM_Edge returns [ASPM.Edge element = null]
@init{
}
:
	a0 = 'edge' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[47]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[48]);
	}
	
	(
		a2 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[49]);
	}
	
	a3 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[50]);
	}
	
	(
		a4 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[51]);
	}
	
	a5 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[52]);
	}
	
	(
		a6 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[53]);
	}
	
	a7 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[54]);
	}
	
	(
		a8 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[55]);
	}
	
	a9 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[56]);
	}
	
	(
		a10 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[57]);
	}
	
	a11 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_11, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[58]);
	}
	
	(
		a12 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[59]);
	}
	
	a13 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_13, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[60]);
	}
	
	(
		a14 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[61]);
	}
	
	a15 = ',' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_15, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[62]);
	}
	
	(
		a16 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[63]);
	}
	
	a17 = ')' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_17, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[64]);
	}
	
	a18 = '.' {
		if (element == null) {
			element = ASPM.ASPMFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPM.resource.aspm.grammar.AspmGrammarInformationProvider.ASPM_3_0_0_18, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASPM.ASPMPackage.eINSTANCE.getModel(), ASPM.resource.aspm.mopp.AspmExpectationConstants.EXPECTATIONS[65]);
	}
	
;

TEXT:
	(('A'..'Z'|'a'..'z'|'0'..'9'|'-'|'_'|'/'|'@'|'.'|':')+)
;
LINEBREAK:
	(('\r\n'|'\r'|'\n'))
	{ _channel = 99; }
;
WHITESPACE:
	((' '|'\t'|'\f'))
	{ _channel = 99; }
;
QUOTED_34_34_92:
	(('"')(('\\''"')|('\\''\\')|(~('"'|'\\')))*('"'))
;

