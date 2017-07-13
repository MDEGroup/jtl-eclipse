// $ANTLR 3.4

	package ASPM.resource.aspm.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AspmLexer extends Lexer {
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

    public AspmLexer() {} 
    public AspmLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public AspmLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Aspm.g"; }

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspm.g:15:6: ( '(' )
            // Aspm.g:15:8: '('
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
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspm.g:16:6: ( ')' )
            // Aspm.g:16:8: ')'
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
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspm.g:17:7: ( ',' )
            // Aspm.g:17:9: ','
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspm.g:18:7: ( '.' )
            // Aspm.g:18:9: '.'
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspm.g:19:7: ( 'edge' )
            // Aspm.g:19:9: 'edge'
            {
            match("edge"); 



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
            // Aspm.g:20:7: ( 'model' )
            // Aspm.g:20:9: 'model'
            {
            match("model"); 



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
            // Aspm.g:21:7: ( 'node' )
            // Aspm.g:21:9: 'node'
            {
            match("node"); 



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
            // Aspm.g:22:7: ( 'prop' )
            // Aspm.g:22:9: 'prop'
            {
            match("prop"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspm.g:1882:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' | '/' | '@' | '.' | ':' )+ ) )
            // Aspm.g:1883:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' | '/' | '@' | '.' | ':' )+ )
            {
            // Aspm.g:1883:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' | '/' | '@' | '.' | ':' )+ )
            // Aspm.g:1883:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' | '/' | '@' | '.' | ':' )+
            {
            // Aspm.g:1883:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' | '/' | '@' | '.' | ':' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '-' && LA1_0 <= ':')||(LA1_0 >= '@' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Aspm.g:
            	    {
            	    if ( (input.LA(1) >= '-' && input.LA(1) <= ':')||(input.LA(1) >= '@' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
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

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspm.g:1885:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Aspm.g:1886:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Aspm.g:1886:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Aspm.g:1886:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Aspm.g:1886:3: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // Aspm.g:1886:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Aspm.g:1886:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Aspm.g:1886:16: '\\n'
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

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspm.g:1889:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Aspm.g:1890:2: ( ( ' ' | '\\t' | '\\f' ) )
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

    // $ANTLR start "QUOTED_34_34_92"
    public final void mQUOTED_34_34_92() throws RecognitionException {
        try {
            int _type = QUOTED_34_34_92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspm.g:1893:16: ( ( ( '\"' ) ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) | (~ ( '\"' | '\\\\' ) ) )* ( '\"' ) ) )
            // Aspm.g:1894:2: ( ( '\"' ) ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) | (~ ( '\"' | '\\\\' ) ) )* ( '\"' ) )
            {
            // Aspm.g:1894:2: ( ( '\"' ) ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) | (~ ( '\"' | '\\\\' ) ) )* ( '\"' ) )
            // Aspm.g:1894:3: ( '\"' ) ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) | (~ ( '\"' | '\\\\' ) ) )* ( '\"' )
            {
            // Aspm.g:1894:3: ( '\"' )
            // Aspm.g:1894:4: '\"'
            {
            match('\"'); 

            }


            // Aspm.g:1894:8: ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) | (~ ( '\"' | '\\\\' ) ) )*
            loop3:
            do {
                int alt3=4;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\\') ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2=='\"') ) {
                        alt3=1;
                    }
                    else if ( (LA3_2=='\\') ) {
                        alt3=2;
                    }


                }
                else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '[')||(LA3_0 >= ']' && LA3_0 <= '\uFFFF')) ) {
                    alt3=3;
                }


                switch (alt3) {
            	case 1 :
            	    // Aspm.g:1894:9: ( '\\\\' '\"' )
            	    {
            	    // Aspm.g:1894:9: ( '\\\\' '\"' )
            	    // Aspm.g:1894:10: '\\\\' '\"'
            	    {
            	    match('\\'); 

            	    match('\"'); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // Aspm.g:1894:19: ( '\\\\' '\\\\' )
            	    {
            	    // Aspm.g:1894:19: ( '\\\\' '\\\\' )
            	    // Aspm.g:1894:20: '\\\\' '\\\\'
            	    {
            	    match('\\'); 

            	    match('\\'); 

            	    }


            	    }
            	    break;
            	case 3 :
            	    // Aspm.g:1894:30: (~ ( '\"' | '\\\\' ) )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
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
            	    break loop3;
                }
            } while (true);


            // Aspm.g:1894:45: ( '\"' )
            // Aspm.g:1894:46: '\"'
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
    // $ANTLR end "QUOTED_34_34_92"

    public void mTokens() throws RecognitionException {
        // Aspm.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | TEXT | LINEBREAK | WHITESPACE | QUOTED_34_34_92 )
        int alt4=12;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt4=1;
            }
            break;
        case ')':
            {
            alt4=2;
            }
            break;
        case ',':
            {
            alt4=3;
            }
            break;
        case '.':
            {
            int LA4_4 = input.LA(2);

            if ( ((LA4_4 >= '-' && LA4_4 <= ':')||(LA4_4 >= '@' && LA4_4 <= 'Z')||LA4_4=='_'||(LA4_4 >= 'a' && LA4_4 <= 'z')) ) {
                alt4=9;
            }
            else {
                alt4=4;
            }
            }
            break;
        case 'e':
            {
            int LA4_5 = input.LA(2);

            if ( (LA4_5=='d') ) {
                int LA4_14 = input.LA(3);

                if ( (LA4_14=='g') ) {
                    int LA4_18 = input.LA(4);

                    if ( (LA4_18=='e') ) {
                        int LA4_22 = input.LA(5);

                        if ( ((LA4_22 >= '-' && LA4_22 <= ':')||(LA4_22 >= '@' && LA4_22 <= 'Z')||LA4_22=='_'||(LA4_22 >= 'a' && LA4_22 <= 'z')) ) {
                            alt4=9;
                        }
                        else {
                            alt4=5;
                        }
                    }
                    else {
                        alt4=9;
                    }
                }
                else {
                    alt4=9;
                }
            }
            else {
                alt4=9;
            }
            }
            break;
        case 'm':
            {
            int LA4_6 = input.LA(2);

            if ( (LA4_6=='o') ) {
                int LA4_15 = input.LA(3);

                if ( (LA4_15=='d') ) {
                    int LA4_19 = input.LA(4);

                    if ( (LA4_19=='e') ) {
                        int LA4_23 = input.LA(5);

                        if ( (LA4_23=='l') ) {
                            int LA4_27 = input.LA(6);

                            if ( ((LA4_27 >= '-' && LA4_27 <= ':')||(LA4_27 >= '@' && LA4_27 <= 'Z')||LA4_27=='_'||(LA4_27 >= 'a' && LA4_27 <= 'z')) ) {
                                alt4=9;
                            }
                            else {
                                alt4=6;
                            }
                        }
                        else {
                            alt4=9;
                        }
                    }
                    else {
                        alt4=9;
                    }
                }
                else {
                    alt4=9;
                }
            }
            else {
                alt4=9;
            }
            }
            break;
        case 'n':
            {
            int LA4_7 = input.LA(2);

            if ( (LA4_7=='o') ) {
                int LA4_16 = input.LA(3);

                if ( (LA4_16=='d') ) {
                    int LA4_20 = input.LA(4);

                    if ( (LA4_20=='e') ) {
                        int LA4_24 = input.LA(5);

                        if ( ((LA4_24 >= '-' && LA4_24 <= ':')||(LA4_24 >= '@' && LA4_24 <= 'Z')||LA4_24=='_'||(LA4_24 >= 'a' && LA4_24 <= 'z')) ) {
                            alt4=9;
                        }
                        else {
                            alt4=7;
                        }
                    }
                    else {
                        alt4=9;
                    }
                }
                else {
                    alt4=9;
                }
            }
            else {
                alt4=9;
            }
            }
            break;
        case 'p':
            {
            int LA4_8 = input.LA(2);

            if ( (LA4_8=='r') ) {
                int LA4_17 = input.LA(3);

                if ( (LA4_17=='o') ) {
                    int LA4_21 = input.LA(4);

                    if ( (LA4_21=='p') ) {
                        int LA4_25 = input.LA(5);

                        if ( ((LA4_25 >= '-' && LA4_25 <= ':')||(LA4_25 >= '@' && LA4_25 <= 'Z')||LA4_25=='_'||(LA4_25 >= 'a' && LA4_25 <= 'z')) ) {
                            alt4=9;
                        }
                        else {
                            alt4=8;
                        }
                    }
                    else {
                        alt4=9;
                    }
                }
                else {
                    alt4=9;
                }
            }
            else {
                alt4=9;
            }
            }
            break;
        case '-':
        case '/':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case ':':
        case '@':
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'o':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt4=9;
            }
            break;
        case '\n':
        case '\r':
            {
            alt4=10;
            }
            break;
        case '\t':
        case '\f':
        case ' ':
            {
            alt4=11;
            }
            break;
        case '\"':
            {
            alt4=12;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 4, 0, input);

            throw nvae;

        }

        switch (alt4) {
            case 1 :
                // Aspm.g:1:10: T__8
                {
                mT__8(); 


                }
                break;
            case 2 :
                // Aspm.g:1:15: T__9
                {
                mT__9(); 


                }
                break;
            case 3 :
                // Aspm.g:1:20: T__10
                {
                mT__10(); 


                }
                break;
            case 4 :
                // Aspm.g:1:26: T__11
                {
                mT__11(); 


                }
                break;
            case 5 :
                // Aspm.g:1:32: T__12
                {
                mT__12(); 


                }
                break;
            case 6 :
                // Aspm.g:1:38: T__13
                {
                mT__13(); 


                }
                break;
            case 7 :
                // Aspm.g:1:44: T__14
                {
                mT__14(); 


                }
                break;
            case 8 :
                // Aspm.g:1:50: T__15
                {
                mT__15(); 


                }
                break;
            case 9 :
                // Aspm.g:1:56: TEXT
                {
                mTEXT(); 


                }
                break;
            case 10 :
                // Aspm.g:1:61: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 11 :
                // Aspm.g:1:71: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 12 :
                // Aspm.g:1:82: QUOTED_34_34_92
                {
                mQUOTED_34_34_92(); 


                }
                break;

        }

    }


 

}