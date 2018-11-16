grammar Aspt;

options {
	superClass = AsptANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package ASPT.resource.aspt.mopp;
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
	package ASPT.resource.aspt.mopp;
}

@members{
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_ASPT_TraceModel{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_ASPT_TraceModel returns [ASPT.TraceModel element = null]
@init{
}
:
	a0 = 'trace_model' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[1]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[2]);
	}
	
	(
		a2 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[3]);
	}
	
	a3 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[4]);
	}
	
	(
		a4 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[5]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[6]);
	}
	
	a6 = '.' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_0_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[7]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[8]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[9]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[10]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[11]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[12]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[13]);
	}
	
	(
		(
			(
				a7_0 = parse_ASPT_TraceElement				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[14]);
				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[15]);
				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[16]);
				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[17]);
				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[18]);
				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[19]);
				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[20]);
			}
			
			
			|			(
				a8_0 = parse_ASPT_TraceLink				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[21]);
				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[22]);
				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[23]);
				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[24]);
				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[25]);
				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[26]);
				addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[27]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[28]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[29]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[30]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[31]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[32]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[33]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[34]);
	}
	
;

parse_ASPT_TraceNode returns [ASPT.TraceNode element = null]
@init{
}
:
	a0 = 'trace_node' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[35]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[36]);
	}
	
	(
		a2 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[37]);
	}
	
	a3 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[38]);
	}
	
	(
		a4 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[39]);
	}
	
	a5 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[40]);
	}
	
	(
		a6 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[41]);
	}
	
	a7 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[42]);
	}
	
	(
		a8 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[43]);
	}
	
	a9 = ')' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[44]);
	}
	
	a10 = '.' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_1_0_0_10, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[45]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[46]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[47]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[48]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[49]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[50]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[51]);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_ASPT_TraceNbNode{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_ASPT_TraceProp returns [ASPT.TraceProp element = null]
@init{
}
:
	a0 = 'trace_prop' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[52]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[53]);
	}
	
	(
		a2 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[54]);
	}
	
	a3 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[55]);
	}
	
	(
		a4 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[56]);
	}
	
	a5 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[57]);
	}
	
	(
		a6 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[58]);
	}
	
	a7 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[59]);
	}
	
	(
		a8 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[60]);
	}
	
	a9 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[61]);
	}
	
	(
		a10 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[62]);
	}
	
	a11 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_11, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[63]);
	}
	
	(
		a12 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[64]);
	}
	
	a13 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_13, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[65]);
	}
	
	(
		a14 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[66]);
	}
	
	a15 = ')' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_15, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[67]);
	}
	
	a16 = '.' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_2_0_0_16, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[68]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[69]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[70]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[71]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[72]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[73]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[74]);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_ASPT_TraceNbProp{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_ASPT_TraceEdge returns [ASPT.TraceEdge element = null]
@init{
}
:
	a0 = 'trace_edge' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[75]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[76]);
	}
	
	(
		a2 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[77]);
	}
	
	a3 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[78]);
	}
	
	(
		a4 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[79]);
	}
	
	a5 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[80]);
	}
	
	(
		a6 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[81]);
	}
	
	a7 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[82]);
	}
	
	(
		a8 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[83]);
	}
	
	a9 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[84]);
	}
	
	(
		a10 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[85]);
	}
	
	a11 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_11, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[86]);
	}
	
	(
		a12 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[87]);
	}
	
	a13 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_13, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[88]);
	}
	
	(
		a14 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[89]);
	}
	
	a15 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_15, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[90]);
	}
	
	(
		a16 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[91]);
	}
	
	a17 = ')' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_17, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[92]);
	}
	
	a18 = '.' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_3_0_0_18, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[93]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[94]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[95]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[96]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[97]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[98]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[99]);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_ASPT_TraceNbEdge{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_ASPT_TraceNbEdge returns [ASPT.TraceNbEdge element = null]
@init{
}
:
	a0 = 'trace_nb_edge' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[100]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[101]);
	}
	
	(
		a2 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[102]);
	}
	
	a3 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[103]);
	}
	
	(
		a4 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[104]);
	}
	
	a5 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[105]);
	}
	
	(
		a6 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[106]);
	}
	
	a7 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[107]);
	}
	
	(
		a8 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[108]);
	}
	
	a9 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[109]);
	}
	
	(
		a10 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[110]);
	}
	
	a11 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_11, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[111]);
	}
	
	(
		a12 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[112]);
	}
	
	a13 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_13, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[113]);
	}
	
	(
		a14 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[114]);
	}
	
	a15 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_15, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[115]);
	}
	
	(
		a16 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[116]);
	}
	
	a17 = ')' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_17, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[117]);
	}
	
	a18 = '.' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_4_0_0_18, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[118]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[119]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[120]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[121]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[122]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[123]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[124]);
	}
	
;

parse_ASPT_TraceNbProp returns [ASPT.TraceNbProp element = null]
@init{
}
:
	a0 = 'trace_nb_prop' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[125]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[126]);
	}
	
	(
		a2 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[127]);
	}
	
	a3 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[128]);
	}
	
	(
		a4 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[129]);
	}
	
	a5 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[130]);
	}
	
	(
		a6 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[131]);
	}
	
	a7 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[132]);
	}
	
	(
		a8 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[133]);
	}
	
	a9 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[134]);
	}
	
	(
		a10 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[135]);
	}
	
	a11 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_11, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[136]);
	}
	
	(
		a12 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[137]);
	}
	
	a13 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_13, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[138]);
	}
	
	(
		a14 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[139]);
	}
	
	a15 = ')' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_15, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[140]);
	}
	
	a16 = '.' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_5_0_0_16, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[141]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[142]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[143]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[144]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[145]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[146]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[147]);
	}
	
;

parse_ASPT_TraceNbNode returns [ASPT.TraceNbNode element = null]
@init{
}
:
	a0 = 'trace_nb_node' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[148]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[149]);
	}
	
	(
		a2 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[150]);
	}
	
	a3 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[151]);
	}
	
	(
		a4 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[152]);
	}
	
	a5 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[153]);
	}
	
	(
		a6 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[154]);
	}
	
	a7 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[155]);
	}
	
	(
		a8 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[156]);
	}
	
	a9 = ')' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[157]);
	}
	
	a10 = '.' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceNbNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_6_0_0_10, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[158]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[159]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[160]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[161]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[162]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[163]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[164]);
	}
	
;

parse_ASPT_TraceLink returns [ASPT.TraceLink element = null]
@init{
}
:
	a0 = 'trace_link' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[165]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[166]);
	}
	
	(
		a2 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[167]);
	}
	
	a3 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[168]);
	}
	
	(
		a4 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[169]);
	}
	
	a5 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[170]);
	}
	
	(
		a6 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[171]);
	}
	
	a7 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[172]);
	}
	
	(
		a8 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[173]);
	}
	
	a9 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[174]);
	}
	
	(
		a10 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[175]);
	}
	
	a11 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_11, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[176]);
	}
	
	(
		a12 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[177]);
	}
	
	a13 = ',' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_13, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[178]);
	}
	
	(
		a14 = QUOTED_34_34_92		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[179]);
	}
	
	a15 = ')' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_15, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[180]);
	}
	
	a16 = '.' {
		if (element == null) {
			element = ASPT.ASPTFactory.eINSTANCE.createTraceLink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASPT.resource.aspt.grammar.AsptGrammarInformationProvider.ASPT_7_0_0_16, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[181]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[182]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[183]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[184]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[185]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[186]);
		addExpectedElement(ASPT.ASPTPackage.eINSTANCE.getTraceModel(), ASPT.resource.aspt.mopp.AsptExpectationConstants.EXPECTATIONS[187]);
	}
	
;

parse_ASPT_TraceElement returns [ASPT.TraceElement element = null]
:
	c0 = parse_ASPT_TraceNode{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_ASPT_TraceProp{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_ASPT_TraceEdge{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_ASPT_TraceNbEdge{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_ASPT_TraceNbProp{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_ASPT_TraceNbNode{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_ASPT_TraceLink{ element = c6; /* this is a subclass or primitive expression choice */ }
	
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

