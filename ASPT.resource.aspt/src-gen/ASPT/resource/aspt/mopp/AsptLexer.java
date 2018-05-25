// $ANTLR 3.4

	package ASPT.resource.aspt.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AsptLexer extends Lexer {
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
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int FLOAT=4;
    public static final int IDENTIFIER=5;
    public static final int INTEGER=6;
    public static final int LINEBREAK=7;
    public static final int QUOTED_34_34=8;
    public static final int SL_COMMENT=9;
    public static final int WHITESPACE=10;

    	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
    	
    	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public AsptLexer() {} 
    public AsptLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public AsptLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Aspt.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:15:7: ( '(' )
            // Aspt.g:15:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:16:7: ( ')' )
            // Aspt.g:16:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:17:7: ( ',' )
            // Aspt.g:17:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:18:7: ( '.' )
            // Aspt.g:18:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:19:7: ( 'trace_edge' )
            // Aspt.g:19:9: 'trace_edge'
            {
            match("trace_edge"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:20:7: ( 'trace_link' )
            // Aspt.g:20:9: 'trace_link'
            {
            match("trace_link"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:21:7: ( 'trace_model' )
            // Aspt.g:21:9: 'trace_model'
            {
            match("trace_model"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:22:7: ( 'trace_nb_edge' )
            // Aspt.g:22:9: 'trace_nb_edge'
            {
            match("trace_nb_edge"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:23:7: ( 'trace_nb_node' )
            // Aspt.g:23:9: 'trace_nb_node'
            {
            match("trace_nb_node"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:24:7: ( 'trace_nb_prop' )
            // Aspt.g:24:9: 'trace_nb_prop'
            {
            match("trace_nb_prop"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:25:7: ( 'trace_node' )
            // Aspt.g:25:9: 'trace_node'
            {
            match("trace_node"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:26:7: ( 'trace_prop' )
            // Aspt.g:26:9: 'trace_prop'
            {
            match("trace_prop"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:3422:11: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '-' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' | '/' | '.' | '@' )* ) )
            // Aspt.g:3423:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '-' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' | '/' | '.' | '@' )* )
            {
            // Aspt.g:3423:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '-' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' | '/' | '.' | '@' )* )
            // Aspt.g:3423:3: ( 'A' .. 'Z' | 'a' .. 'z' | '-' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' | '/' | '.' | '@' )*
            {
            if ( input.LA(1)=='-'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Aspt.g:3423:35: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' | '/' | '.' | '@' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '-' && LA1_0 <= '9')||(LA1_0 >= '@' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Aspt.g:
            	    {
            	    if ( (input.LA(1) >= '-' && input.LA(1) <= '9')||(input.LA(1) >= '@' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:3425:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Aspt.g:3426:2: ( ( ' ' | '\\t' | '\\f' ) )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:3429:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Aspt.g:3430:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Aspt.g:3430:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Aspt.g:3430:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Aspt.g:3430:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='\n') ) {
                    alt2=1;
                }
                else {
                    alt2=2;
                }
            }
            else if ( (LA2_0=='\n') ) {
                alt2=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // Aspt.g:3430:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Aspt.g:3430:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Aspt.g:3430:20: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINEBREAK"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:3433:8: ( ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) )
            // Aspt.g:3434:2: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            {
            // Aspt.g:3434:2: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-'||(LA5_0 >= '1' && LA5_0 <= '9')) ) {
                alt5=1;
            }
            else if ( (LA5_0=='0') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // Aspt.g:3434:3: ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // Aspt.g:3434:3: ( '-' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='-') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // Aspt.g:3434:4: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // Aspt.g:3434:19: ( '0' .. '9' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Aspt.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Aspt.g:3434:31: '0'
                    {
                    match('0'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:3436:6: ( ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ ) )
            // Aspt.g:3437:2: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            {
            // Aspt.g:3437:2: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            // Aspt.g:3437:3: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+
            {
            // Aspt.g:3437:3: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Aspt.g:3437:4: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Aspt.g:3437:9: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0 >= '1' && LA8_0 <= '9')) ) {
                alt8=1;
            }
            else if ( (LA8_0=='0') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // Aspt.g:3437:10: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // Aspt.g:3437:21: ( '0' .. '9' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // Aspt.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Aspt.g:3437:35: '0'
                    {
                    match('0'); 

                    }
                    break;

            }


            match('.'); 

            // Aspt.g:3437:44: ( '0' .. '9' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Aspt.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:3440:11: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Aspt.g:3441:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Aspt.g:3441:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Aspt.g:3441:3: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 



            // Aspt.g:3441:7: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '\u0000' && LA10_0 <= '\t')||(LA10_0 >= '\u000B' && LA10_0 <= '\f')||(LA10_0 >= '\u000E' && LA10_0 <= '\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Aspt.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFE') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "QUOTED_34_34"
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:3444:13: ( ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) ) )
            // Aspt.g:3445:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            {
            // Aspt.g:3445:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            // Aspt.g:3445:3: ( '\"' ) (~ ( '\"' ) )* ( '\"' )
            {
            // Aspt.g:3445:3: ( '\"' )
            // Aspt.g:3445:4: '\"'
            {
            match('\"'); 

            }


            // Aspt.g:3445:8: (~ ( '\"' ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= '\u0000' && LA11_0 <= '!')||(LA11_0 >= '#' && LA11_0 <= '\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Aspt.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            // Aspt.g:3445:17: ( '\"' )
            // Aspt.g:3445:18: '\"'
            {
            match('\"'); 

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_34_34"

    public void mTokens() throws RecognitionException {
        // Aspt.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | IDENTIFIER | WHITESPACE | LINEBREAK | INTEGER | FLOAT | SL_COMMENT | QUOTED_34_34 )
        int alt12=19;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // Aspt.g:1:10: T__11
                {
                mT__11(); 


                }
                break;
            case 2 :
                // Aspt.g:1:16: T__12
                {
                mT__12(); 


                }
                break;
            case 3 :
                // Aspt.g:1:22: T__13
                {
                mT__13(); 


                }
                break;
            case 4 :
                // Aspt.g:1:28: T__14
                {
                mT__14(); 


                }
                break;
            case 5 :
                // Aspt.g:1:34: T__15
                {
                mT__15(); 


                }
                break;
            case 6 :
                // Aspt.g:1:40: T__16
                {
                mT__16(); 


                }
                break;
            case 7 :
                // Aspt.g:1:46: T__17
                {
                mT__17(); 


                }
                break;
            case 8 :
                // Aspt.g:1:52: T__18
                {
                mT__18(); 


                }
                break;
            case 9 :
                // Aspt.g:1:58: T__19
                {
                mT__19(); 


                }
                break;
            case 10 :
                // Aspt.g:1:64: T__20
                {
                mT__20(); 


                }
                break;
            case 11 :
                // Aspt.g:1:70: T__21
                {
                mT__21(); 


                }
                break;
            case 12 :
                // Aspt.g:1:76: T__22
                {
                mT__22(); 


                }
                break;
            case 13 :
                // Aspt.g:1:82: IDENTIFIER
                {
                mIDENTIFIER(); 


                }
                break;
            case 14 :
                // Aspt.g:1:93: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 15 :
                // Aspt.g:1:104: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 16 :
                // Aspt.g:1:114: INTEGER
                {
                mINTEGER(); 


                }
                break;
            case 17 :
                // Aspt.g:1:122: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 18 :
                // Aspt.g:1:128: SL_COMMENT
                {
                mSL_COMMENT(); 


                }
                break;
            case 19 :
                // Aspt.g:1:139: QUOTED_34_34
                {
                mQUOTED_34_34(); 


                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\5\uffff\2\11\3\uffff\2\22\2\uffff\3\11\1\22\2\uffff\30\11\1\64"+
        "\1\65\4\11\1\72\1\73\2\uffff\1\74\3\11\3\uffff\3\11\1\103\1\104"+
        "\1\105\3\uffff";
    static final String DFA12_eofS =
        "\106\uffff";
    static final String DFA12_minS =
        "\1\11\4\uffff\1\162\1\60\3\uffff\2\56\2\uffff\1\141\3\56\2\uffff"+
        "\1\143\1\56\1\60\1\145\1\60\1\137\1\145\1\144\1\151\1\157\1\142"+
        "\1\162\1\147\1\156\1\144\1\137\1\144\1\157\1\145\1\153\3\145\1\160"+
        "\2\55\1\154\1\144\1\157\1\162\2\55\2\uffff\1\55\1\147\1\144\1\157"+
        "\3\uffff\2\145\1\160\3\55\3\uffff";
    static final String DFA12_maxS =
        "\1\172\4\uffff\1\162\1\71\3\uffff\1\71\1\56\2\uffff\1\141\1\71\1"+
        "\56\1\71\2\uffff\1\143\2\71\1\145\1\71\1\137\1\160\1\144\1\151\2"+
        "\157\1\162\1\147\1\156\1\144\1\137\1\144\1\157\1\145\1\153\1\145"+
        "\1\160\1\145\1\160\2\172\1\154\1\144\1\157\1\162\2\172\2\uffff\1"+
        "\172\1\147\1\144\1\157\3\uffff\2\145\1\160\3\172\3\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\2\uffff\1\16\1\17\1\15\2\uffff\1\22\1\23"+
        "\4\uffff\1\20\1\21\40\uffff\1\5\1\6\4\uffff\1\13\1\14\1\7\6\uffff"+
        "\1\10\1\11\1\12";
    static final String DFA12_specialS =
        "\106\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\7\1\10\1\uffff\1\7\1\10\22\uffff\1\7\1\uffff\1\15\5\uffff"+
            "\1\1\1\2\2\uffff\1\3\1\6\1\4\1\14\1\13\11\12\7\uffff\32\11\4"+
            "\uffff\1\11\1\uffff\23\11\1\5\6\11",
            "",
            "",
            "",
            "",
            "\1\16",
            "\1\20\11\17",
            "",
            "",
            "",
            "\1\23\1\uffff\12\21",
            "\1\23",
            "",
            "",
            "\1\24",
            "\1\26\1\uffff\12\25",
            "\1\26",
            "\1\23\1\uffff\12\21",
            "",
            "",
            "\1\27",
            "\1\26\1\uffff\12\25",
            "\12\30",
            "\1\31",
            "\12\30",
            "\1\32",
            "\1\33\6\uffff\1\34\1\35\1\36\1\uffff\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43\14\uffff\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57\10\uffff\1\60\1\uffff\1\61",
            "\1\62",
            "\1\63",
            "\15\11\6\uffff\33\11\4\uffff\1\11\1\uffff\32\11",
            "\15\11\6\uffff\33\11\4\uffff\1\11\1\uffff\32\11",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\15\11\6\uffff\33\11\4\uffff\1\11\1\uffff\32\11",
            "\15\11\6\uffff\33\11\4\uffff\1\11\1\uffff\32\11",
            "",
            "",
            "\15\11\6\uffff\33\11\4\uffff\1\11\1\uffff\32\11",
            "\1\75",
            "\1\76",
            "\1\77",
            "",
            "",
            "",
            "\1\100",
            "\1\101",
            "\1\102",
            "\15\11\6\uffff\33\11\4\uffff\1\11\1\uffff\32\11",
            "\15\11\6\uffff\33\11\4\uffff\1\11\1\uffff\32\11",
            "\15\11\6\uffff\33\11\4\uffff\1\11\1\uffff\32\11",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | IDENTIFIER | WHITESPACE | LINEBREAK | INTEGER | FLOAT | SL_COMMENT | QUOTED_34_34 );";
        }
    }
 

}