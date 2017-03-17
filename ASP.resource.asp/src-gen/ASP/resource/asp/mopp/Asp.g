grammar Asp;

options {
	superClass = AspANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package ASP.resource.asp.mopp;
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
	package ASP.resource.asp.mopp;
}

@members{
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
		int followSetID = 78;
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
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
	(
		c0 = parse_ASP_Transformation{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_ASP_Transformation returns [ASP.Transformation element = null]
@init{
}
:
	(
		(
			a0_0 = parse_ASP_Element			{
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
		)
		
	)+	{
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
	
	(
		(
			a1_0 = parse_ASP_Relation			{
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
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[24]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[25]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[26]);
	}
	
	(
		(
			a2_0 = parse_ASP_Constraint			{
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
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[27]);
	}
	
;

parse_ASP_Relation returns [ASP.Relation element = null]
@init{
}
:
	(
		a0_0 = parse_ASP_Pattern		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getRelation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[28]);
	}
	
	(
		a1_0 = parse_ASP_RightPattern		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[29]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[30]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[31]);
	}
	
;

parse_ASP_LeftPattern returns [ASP.LeftPattern element = null]
@init{
}
:
	(
		(
			a0 = 'relation_node' {
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
			|			a1 = 'relation_prop' {
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
			|			a2 = 'relation_edge' {
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
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[32]);
	}
	
	(
		a5 = QUOTED_40_41		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[33]);
	}
	
	a6 = '.' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createLeftPattern();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_2_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getRelation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[34]);
	}
	
;

parse_ASP_RightPattern returns [ASP.RightPattern element = null]
@init{
}
:
	(
		(
			a0 = 'relation_node' {
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
			|			a1 = 'relation_prop' {
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
			|			a2 = 'relation_edge' {
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
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[35]);
	}
	
	(
		a5 = QUOTED_40_41		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[36]);
	}
	
	a6 = '.' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createRightPattern();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_3_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getRelation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[37]);
	}
	
;

parse_ASP_Metanode returns [ASP.Metanode element = null]
@init{
}
:
	a0 = 'metanode(' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createMetanode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_4_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[38]);
	}
	
	(
		a1 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[39]);
	}
	
	a2 = ',' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createMetanode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_4_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[40]);
	}
	
	(
		a3 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[41]);
	}
	
	a4 = ').' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createMetanode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_4_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[42]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[43]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[44]);
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
	}
	
;

parse_ASP_Metaprop returns [ASP.Metaprop element = null]
@init{
}
:
	a0 = 'metaprop(' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createMetaprop();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_5_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[55]);
	}
	
	(
		a1 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[56]);
	}
	
	a2 = ',' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createMetaprop();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_5_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[57]);
	}
	
	(
		a3 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[58]);
	}
	
	a4 = ',' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createMetaprop();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_5_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[59]);
	}
	
	(
		a5 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[60]);
	}
	
	a6 = ').' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createMetaprop();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_5_0_0_8, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[61]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[62]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[63]);
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
	}
	
;

parse_ASP_Metaedge returns [ASP.Metaedge element = null]
@init{
}
:
	a0 = 'metaedge(' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createMetaedge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_6_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[74]);
	}
	
	(
		a1 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[75]);
	}
	
	a2 = ',' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createMetaedge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_6_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[76]);
	}
	
	(
		a3 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[77]);
	}
	
	a4 = ',' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createMetaedge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_6_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[78]);
	}
	
	(
		a5 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[79]);
	}
	
	a6 = ',' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createMetaedge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_6_0_0_8, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[80]);
	}
	
	(
		a7 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[81]);
	}
	
	a8 = ').' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createMetaedge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_6_0_0_11, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[82]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[83]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[84]);
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
	}
	
;

parse_ASP_Node returns [ASP.Node element = null]
@init{
}
:
	(
		(
			a0 = 'nodex(' {
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
			|			a1 = 'node(' {
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
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[95]);
	}
	
	(
		a3 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[96]);
	}
	
	a4 = ',' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_7_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[97]);
	}
	
	(
		a5 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[98]);
	}
	
	a6 = ',' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_7_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[99]);
	}
	
	(
		a7 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[100]);
	}
	
	a8 = ').' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createNode();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_7_0_0_8, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
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
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[111]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[112]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[113]);
	}
	
;

parse_ASP_Prop returns [ASP.Prop element = null]
@init{
}
:
	(
		(
			a0 = 'propx(' {
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
			|			a1 = 'prop(' {
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
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[114]);
	}
	
	(
		a3 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[115]);
	}
	
	a4 = ',' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_8_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[116]);
	}
	
	(
		a5 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[117]);
	}
	
	a6 = ',' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_8_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[118]);
	}
	
	(
		a7 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[119]);
	}
	
	a8 = ',' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_8_0_0_8, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[120]);
	}
	
	(
		a9 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[121]);
	}
	
	a10 = ').' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createProp();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_8_0_0_11, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[122]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[123]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[124]);
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
	}
	
;

parse_ASP_Edge returns [ASP.Edge element = null]
@init{
}
:
	(
		(
			a0 = 'edgex(' {
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
			|			a1 = 'edge(' {
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
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[135]);
	}
	
	(
		a3 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[136]);
	}
	
	a4 = ',' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[137]);
	}
	
	(
		a5 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[138]);
	}
	
	a6 = ',' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[139]);
	}
	
	(
		a7 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[140]);
	}
	
	a8 = ',' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_8, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[141]);
	}
	
	(
		a9 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[142]);
	}
	
	a10 = ',' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_11, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[143]);
	}
	
	(
		a11 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[144]);
	}
	
	a12 = ').' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createEdge();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_9_0_0_14, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[145]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[146]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[147]);
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
	}
	
;

parse_ASP_Constraint returns [ASP.Constraint element = null]
@init{
}
:
	a0 = ':-' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[158]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[159]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[160]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[161]);
	}
	
	(
		a1_0 = parse_ASP_Expression		{
			if (terminateParsing) {
				throw new ASP.resource.asp.mopp.AspTerminateParsingException();
			}
			if (element == null) {
				element = ASP.ASPFactory.eINSTANCE.createConstraint();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					addObjectToList(element, ASP.ASPPackage.CONSTRAINT__EXPRESSIONS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_2, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[162]);
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[163]);
	}
	
	(
		(
			a2 = ',' {
				if (element == null) {
					element = ASP.ASPFactory.eINSTANCE.createConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[164]);
				addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[165]);
				addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[166]);
				addExpectedElement(ASP.ASPPackage.eINSTANCE.getConstraint(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[167]);
			}
			
			(
				a3_0 = parse_ASP_Expression				{
					if (terminateParsing) {
						throw new ASP.resource.asp.mopp.AspTerminateParsingException();
					}
					if (element == null) {
						element = ASP.ASPFactory.eINSTANCE.createConstraint();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, ASP.ASPPackage.CONSTRAINT__EXPRESSIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_3_0_0_2, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[168]);
				addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[169]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[170]);
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[171]);
	}
	
	a4 = '.' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_10_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[172]);
	}
	
;

parse_ASP_Literal returns [ASP.Literal element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[173]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[174]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[175]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[176]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[177]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[178]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[179]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[180]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[181]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[182]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[183]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[184]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[185]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[186]);
	}
	
	(
		(
			a1 = '.' {
				if (element == null) {
					element = ASP.ASPFactory.eINSTANCE.createLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_11_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
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
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[200]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[201]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[202]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[203]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[204]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[205]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[206]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[207]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[208]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[209]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[210]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[211]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[212]);
	}
	
;

parse_ASP_Terminal returns [ASP.Terminal element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[213]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[214]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[215]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[216]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[217]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[218]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[219]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[220]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[221]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[222]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[223]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[224]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[225]);
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[226]);
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[227]);
	}
	
;

parse_ASP_Not returns [ASP.Not element = null]
@init{
}
:
	a0 = 'not' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createNot();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_13_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[228]);
	}
	
	(
		a1 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[229]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[230]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[231]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[232]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[233]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[234]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[235]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[236]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[237]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[238]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[239]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[240]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[241]);
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[242]);
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[243]);
	}
	
;

parse_ASP_Eq returns [ASP.Eq element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[244]);
	}
	
	a1 = '==' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createEq();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_14_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[245]);
	}
	
	(
		a2 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[246]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[247]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[248]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[249]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[250]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[251]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[252]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[253]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[254]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[255]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[256]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[257]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[258]);
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[259]);
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[260]);
	}
	
;

parse_ASP_NotEq returns [ASP.NotEq element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[261]);
	}
	
	a1 = '!=' {
		if (element == null) {
			element = ASP.ASPFactory.eINSTANCE.createNotEq();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, ASP.resource.asp.grammar.AspGrammarInformationProvider.ASP_15_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[262]);
	}
	
	(
		a2 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[263]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[264]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[265]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[266]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[267]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[268]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[269]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[270]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[271]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[272]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[273]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[274]);
		addExpectedElement(ASP.ASPPackage.eINSTANCE.getTransformation(), ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[275]);
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[276]);
		addExpectedElement(null, ASP.resource.asp.mopp.AspExpectationConstants.EXPECTATIONS[277]);
	}
	
;

parse_ASP_Element returns [ASP.Element element = null]
:
	c0 = parse_ASP_Metanode{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_ASP_Metaprop{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_ASP_Metaedge{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_ASP_Node{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_ASP_Prop{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_ASP_Edge{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_ASP_Literal{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_ASP_Terminal{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_ASP_Not{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_ASP_Eq{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_ASP_NotEq{ element = c10; /* this is a subclass or primitive expression choice */ }
	
;

parse_ASP_Pattern returns [ASP.Pattern element = null]
:
	c0 = parse_ASP_LeftPattern{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_ASP_RightPattern{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_ASP_Expression returns [ASP.Expression element = null]
:
	c0 = parse_ASP_Terminal{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_ASP_Not{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_ASP_Eq{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_ASP_NotEq{ element = c3; /* this is a subclass or primitive expression choice */ }
	
;

COMMENT:
	('%'(~('\n'|'\r'|'\uffff'))*)
	{ _channel = 99; }
;
TEXT:
	(('A'..'Z'|'a'..'z'|'0'..'9'|'-'|'_'|'!'|':')+)
;
LINEBREAK:
	(('\r\n'|'\r'|'\n'))
	{ _channel = 99; }
;
WHITESPACE:
	((' '|'\t'|'\f'))
	{ _channel = 99; }
;
ELEMENT:
	(('A'..'Z'|'a'..'z'|'0'..'9'|'-'|'_'|'!'|':')+('('))
	{ _channel = 99; }
;
QUOTED_40_41:
	(('(')(~(')'))*(')'))
;

