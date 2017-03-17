// $ANTLR 3.4

	package JTL.resource.jtl.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class JtlLexer extends Lexer {
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

    public JtlLexer() {} 
    public JtlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public JtlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Jtl.g"; }

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Jtl.g:15:6: ( '(' )
            // Jtl.g:15:8: '('
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
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Jtl.g:16:7: ( ')' )
            // Jtl.g:16:9: ')'
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Jtl.g:17:7: ( ',' )
            // Jtl.g:17:9: ','
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Jtl.g:18:7: ( ':' )
            // Jtl.g:18:9: ':'
            {
            match(':'); 

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
            // Jtl.g:19:7: ( '::' )
            // Jtl.g:19:9: '::'
            {
            match("::"); 



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
            // Jtl.g:20:7: ( ';' )
            // Jtl.g:20:9: ';'
            {
            match(';'); 

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
            // Jtl.g:21:7: ( '=' )
            // Jtl.g:21:9: '='
            {
            match('='); 

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
            // Jtl.g:22:7: ( 'checkonly' )
            // Jtl.g:22:9: 'checkonly'
            {
            match("checkonly"); 



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
            // Jtl.g:23:7: ( 'domain' )
            // Jtl.g:23:9: 'domain'
            {
            match("domain"); 



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
            // Jtl.g:24:7: ( 'enforce' )
            // Jtl.g:24:9: 'enforce'
            {
            match("enforce"); 



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
            // Jtl.g:25:7: ( 'false' )
            // Jtl.g:25:9: 'false'
            {
            match("false"); 



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
            // Jtl.g:26:7: ( 'relation' )
            // Jtl.g:26:9: 'relation'
            {
            match("relation"); 



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
            // Jtl.g:27:7: ( 'top' )
            // Jtl.g:27:9: 'top'
            {
            match("top"); 



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
            // Jtl.g:28:7: ( 'transformation' )
            // Jtl.g:28:9: 'transformation'
            {
            match("transformation"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Jtl.g:29:7: ( 'true' )
            // Jtl.g:29:9: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Jtl.g:30:7: ( 'when' )
            // Jtl.g:30:9: 'when'
            {
            match("when"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Jtl.g:31:7: ( 'where' )
            // Jtl.g:31:9: 'where'
            {
            match("where"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Jtl.g:32:7: ( '{' )
            // Jtl.g:32:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Jtl.g:33:7: ( '|' )
            // Jtl.g:33:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Jtl.g:34:7: ( '}' )
            // Jtl.g:34:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Jtl.g:35:7: ( '};' )
            // Jtl.g:35:9: '};'
            {
            match("};"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Jtl.g:2827:11: ( ( ( '//' | '--' ) (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Jtl.g:2828:2: ( ( '//' | '--' ) (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Jtl.g:2828:2: ( ( '//' | '--' ) (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Jtl.g:2828:3: ( '//' | '--' ) (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            // Jtl.g:2828:3: ( '//' | '--' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='/') ) {
                alt1=1;
            }
            else if ( (LA1_0=='-') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // Jtl.g:2828:4: '//'
                    {
                    match("//"); 



                    }
                    break;
                case 2 :
                    // Jtl.g:2828:9: '--'
                    {
                    match("--"); 



                    }
                    break;

            }


            // Jtl.g:2828:14: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFE')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Jtl.g:
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
            	    break loop2;
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

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Jtl.g:2831:11: ( ( '/*' ( . )* '*/' ) )
            // Jtl.g:2832:2: ( '/*' ( . )* '*/' )
            {
            // Jtl.g:2832:2: ( '/*' ( . )* '*/' )
            // Jtl.g:2832:3: '/*' ( . )* '*/'
            {
            match("/*"); 



            // Jtl.g:2832:7: ( . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='*') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='/') ) {
                        alt3=2;
                    }
                    else if ( ((LA3_1 >= '\u0000' && LA3_1 <= '.')||(LA3_1 >= '0' && LA3_1 <= '\uFFFF')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0 >= '\u0000' && LA3_0 <= ')')||(LA3_0 >= '+' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Jtl.g:2832:7: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match("*/"); 



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
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Jtl.g:2835:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // Jtl.g:2836:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // Jtl.g:2836:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Jtl.g:2836:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Jtl.g:2836:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='-'||(LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Jtl.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
    // $ANTLR end "TEXT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Jtl.g:2838:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Jtl.g:2839:2: ( ( ' ' | '\\t' | '\\f' ) )
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
            // Jtl.g:2842:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Jtl.g:2843:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Jtl.g:2843:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Jtl.g:2843:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Jtl.g:2843:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='\n') ) {
                    alt5=1;
                }
                else {
                    alt5=2;
                }
            }
            else if ( (LA5_0=='\n') ) {
                alt5=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // Jtl.g:2843:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Jtl.g:2843:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Jtl.g:2843:20: '\\n'
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

    public void mTokens() throws RecognitionException {
        // Jtl.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | SL_COMMENT | ML_COMMENT | TEXT | WHITESPACE | LINEBREAK )
        int alt6=26;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // Jtl.g:1:10: T__9
                {
                mT__9(); 


                }
                break;
            case 2 :
                // Jtl.g:1:15: T__10
                {
                mT__10(); 


                }
                break;
            case 3 :
                // Jtl.g:1:21: T__11
                {
                mT__11(); 


                }
                break;
            case 4 :
                // Jtl.g:1:27: T__12
                {
                mT__12(); 


                }
                break;
            case 5 :
                // Jtl.g:1:33: T__13
                {
                mT__13(); 


                }
                break;
            case 6 :
                // Jtl.g:1:39: T__14
                {
                mT__14(); 


                }
                break;
            case 7 :
                // Jtl.g:1:45: T__15
                {
                mT__15(); 


                }
                break;
            case 8 :
                // Jtl.g:1:51: T__16
                {
                mT__16(); 


                }
                break;
            case 9 :
                // Jtl.g:1:57: T__17
                {
                mT__17(); 


                }
                break;
            case 10 :
                // Jtl.g:1:63: T__18
                {
                mT__18(); 


                }
                break;
            case 11 :
                // Jtl.g:1:69: T__19
                {
                mT__19(); 


                }
                break;
            case 12 :
                // Jtl.g:1:75: T__20
                {
                mT__20(); 


                }
                break;
            case 13 :
                // Jtl.g:1:81: T__21
                {
                mT__21(); 


                }
                break;
            case 14 :
                // Jtl.g:1:87: T__22
                {
                mT__22(); 


                }
                break;
            case 15 :
                // Jtl.g:1:93: T__23
                {
                mT__23(); 


                }
                break;
            case 16 :
                // Jtl.g:1:99: T__24
                {
                mT__24(); 


                }
                break;
            case 17 :
                // Jtl.g:1:105: T__25
                {
                mT__25(); 


                }
                break;
            case 18 :
                // Jtl.g:1:111: T__26
                {
                mT__26(); 


                }
                break;
            case 19 :
                // Jtl.g:1:117: T__27
                {
                mT__27(); 


                }
                break;
            case 20 :
                // Jtl.g:1:123: T__28
                {
                mT__28(); 


                }
                break;
            case 21 :
                // Jtl.g:1:129: T__29
                {
                mT__29(); 


                }
                break;
            case 22 :
                // Jtl.g:1:135: SL_COMMENT
                {
                mSL_COMMENT(); 


                }
                break;
            case 23 :
                // Jtl.g:1:146: ML_COMMENT
                {
                mML_COMMENT(); 


                }
                break;
            case 24 :
                // Jtl.g:1:157: TEXT
                {
                mTEXT(); 


                }
                break;
            case 25 :
                // Jtl.g:1:162: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 26 :
                // Jtl.g:1:173: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\4\uffff\1\27\2\uffff\7\23\2\uffff\1\41\1\uffff\1\23\5\uffff\10"+
        "\23\4\uffff\1\42\5\23\1\64\3\23\1\42\5\23\1\uffff\1\23\1\77\1\100"+
        "\4\23\1\105\2\23\2\uffff\1\110\1\23\1\112\1\23\1\uffff\2\23\1\uffff"+
        "\1\23\1\uffff\1\117\3\23\1\uffff\1\123\1\23\1\125\1\uffff\1\23\1"+
        "\uffff\4\23\1\133\1\uffff";
    static final String DFA6_eofS =
        "\134\uffff";
    static final String DFA6_minS =
        "\1\11\3\uffff\1\72\2\uffff\1\150\1\157\1\156\1\141\1\145\1\157\1"+
        "\150\2\uffff\1\73\1\52\1\55\5\uffff\1\145\1\155\1\146\2\154\1\160"+
        "\1\141\1\145\4\uffff\1\55\1\143\1\141\1\157\1\163\1\141\1\55\1\156"+
        "\1\145\1\156\1\55\1\153\1\151\1\162\1\145\1\164\1\uffff\1\163\2"+
        "\55\1\145\1\157\1\156\1\143\1\55\1\151\1\146\2\uffff\1\55\1\156"+
        "\1\55\1\145\1\uffff\2\157\1\uffff\1\154\1\uffff\1\55\1\156\1\162"+
        "\1\171\1\uffff\1\55\1\155\1\55\1\uffff\1\141\1\uffff\1\164\1\151"+
        "\1\157\1\156\1\55\1\uffff";
    static final String DFA6_maxS =
        "\1\175\3\uffff\1\72\2\uffff\1\150\1\157\1\156\1\141\1\145\1\162"+
        "\1\150\2\uffff\1\73\1\57\1\55\5\uffff\1\145\1\155\1\146\2\154\1"+
        "\160\1\165\1\145\4\uffff\1\172\1\143\1\141\1\157\1\163\1\141\1\172"+
        "\1\156\1\145\1\162\1\172\1\153\1\151\1\162\1\145\1\164\1\uffff\1"+
        "\163\2\172\1\145\1\157\1\156\1\143\1\172\1\151\1\146\2\uffff\1\172"+
        "\1\156\1\172\1\145\1\uffff\2\157\1\uffff\1\154\1\uffff\1\172\1\156"+
        "\1\162\1\171\1\uffff\1\172\1\155\1\172\1\uffff\1\141\1\uffff\1\164"+
        "\1\151\1\157\1\156\1\172\1\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\1\7\7\uffff\1\22\1\23\3\uffff\1"+
        "\30\1\31\1\32\1\5\1\4\10\uffff\1\25\1\24\1\26\1\27\20\uffff\1\15"+
        "\12\uffff\1\17\1\20\4\uffff\1\13\2\uffff\1\21\1\uffff\1\11\4\uffff"+
        "\1\12\3\uffff\1\14\1\uffff\1\10\5\uffff\1\16";
    static final String DFA6_specialS =
        "\134\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\24\1\25\1\uffff\1\24\1\25\22\uffff\1\24\7\uffff\1\1\1\2\2"+
            "\uffff\1\3\1\22\1\uffff\1\21\12\23\1\4\1\5\1\uffff\1\6\3\uffff"+
            "\32\23\4\uffff\1\23\1\uffff\2\23\1\7\1\10\1\11\1\12\13\23\1"+
            "\13\1\23\1\14\2\23\1\15\3\23\1\16\1\17\1\20",
            "",
            "",
            "",
            "\1\26",
            "",
            "",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35\2\uffff\1\36",
            "\1\37",
            "",
            "",
            "\1\40",
            "\1\43\4\uffff\1\42",
            "\1\44",
            "",
            "",
            "",
            "",
            "",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53\23\uffff\1\54",
            "\1\55",
            "",
            "",
            "",
            "",
            "\1\56\2\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\65",
            "\1\66",
            "\1\67\3\uffff\1\70",
            "\1\56\2\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "",
            "\1\76",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\106",
            "\1\107",
            "",
            "",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\111",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\113",
            "",
            "\1\114",
            "\1\115",
            "",
            "\1\116",
            "",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\120",
            "\1\121",
            "\1\122",
            "",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\124",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "",
            "\1\126",
            "",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | SL_COMMENT | ML_COMMENT | TEXT | WHITESPACE | LINEBREAK );";
        }
    }
 

}