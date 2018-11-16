// $ANTLR 3.4

	package ASPT.resource.aspt.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AsptLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__8=8;
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

    public AsptLexer() {} 
    public AsptLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public AsptLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Aspt.g"; }

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:15:6: ( '(' )
            // Aspt.g:15:8: '('
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
            // Aspt.g:16:6: ( ')' )
            // Aspt.g:16:8: ')'
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
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
    // $ANTLR end "T__19"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspt.g:3422:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' | '/' | '@' | '.' | ':' )+ ) )
            // Aspt.g:3423:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' | '/' | '@' | '.' | ':' )+ )
            {
            // Aspt.g:3423:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' | '/' | '@' | '.' | ':' )+ )
            // Aspt.g:3423:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' | '/' | '@' | '.' | ':' )+
            {
            // Aspt.g:3423:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' | '/' | '@' | '.' | ':' )+
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
            	    // Aspt.g:
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
            // Aspt.g:3425:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Aspt.g:3426:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Aspt.g:3426:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Aspt.g:3426:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Aspt.g:3426:3: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // Aspt.g:3426:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Aspt.g:3426:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Aspt.g:3426:16: '\\n'
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
            // Aspt.g:3429:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Aspt.g:3430:2: ( ( ' ' | '\\t' | '\\f' ) )
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
            // Aspt.g:3433:16: ( ( ( '\"' ) ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) | (~ ( '\"' | '\\\\' ) ) )* ( '\"' ) ) )
            // Aspt.g:3434:2: ( ( '\"' ) ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) | (~ ( '\"' | '\\\\' ) ) )* ( '\"' ) )
            {
            // Aspt.g:3434:2: ( ( '\"' ) ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) | (~ ( '\"' | '\\\\' ) ) )* ( '\"' ) )
            // Aspt.g:3434:3: ( '\"' ) ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) | (~ ( '\"' | '\\\\' ) ) )* ( '\"' )
            {
            // Aspt.g:3434:3: ( '\"' )
            // Aspt.g:3434:4: '\"'
            {
            match('\"'); 

            }


            // Aspt.g:3434:8: ( ( '\\\\' '\"' ) | ( '\\\\' '\\\\' ) | (~ ( '\"' | '\\\\' ) ) )*
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
            	    // Aspt.g:3434:9: ( '\\\\' '\"' )
            	    {
            	    // Aspt.g:3434:9: ( '\\\\' '\"' )
            	    // Aspt.g:3434:10: '\\\\' '\"'
            	    {
            	    match('\\'); 

            	    match('\"'); 

            	    }


            	    }
            	    break;
            	case 2 :
            	    // Aspt.g:3434:19: ( '\\\\' '\\\\' )
            	    {
            	    // Aspt.g:3434:19: ( '\\\\' '\\\\' )
            	    // Aspt.g:3434:20: '\\\\' '\\\\'
            	    {
            	    match('\\'); 

            	    match('\\'); 

            	    }


            	    }
            	    break;
            	case 3 :
            	    // Aspt.g:3434:30: (~ ( '\"' | '\\\\' ) )
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


            // Aspt.g:3434:45: ( '\"' )
            // Aspt.g:3434:46: '\"'
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
        // Aspt.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | TEXT | LINEBREAK | WHITESPACE | QUOTED_34_34_92 )
        int alt4=16;
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
                alt4=13;
            }
            else {
                alt4=4;
            }
            }
            break;
        case 't':
            {
            int LA4_5 = input.LA(2);

            if ( (LA4_5=='r') ) {
                int LA4_11 = input.LA(3);

                if ( (LA4_11=='a') ) {
                    int LA4_12 = input.LA(4);

                    if ( (LA4_12=='c') ) {
                        int LA4_13 = input.LA(5);

                        if ( (LA4_13=='e') ) {
                            int LA4_14 = input.LA(6);

                            if ( (LA4_14=='_') ) {
                                switch ( input.LA(7) ) {
                                case 'e':
                                    {
                                    int LA4_16 = input.LA(8);

                                    if ( (LA4_16=='d') ) {
                                        int LA4_21 = input.LA(9);

                                        if ( (LA4_21=='g') ) {
                                            int LA4_27 = input.LA(10);

                                            if ( (LA4_27=='e') ) {
                                                int LA4_33 = input.LA(11);

                                                if ( ((LA4_33 >= '-' && LA4_33 <= ':')||(LA4_33 >= '@' && LA4_33 <= 'Z')||LA4_33=='_'||(LA4_33 >= 'a' && LA4_33 <= 'z')) ) {
                                                    alt4=13;
                                                }
                                                else {
                                                    alt4=5;
                                                }
                                            }
                                            else {
                                                alt4=13;
                                            }
                                        }
                                        else {
                                            alt4=13;
                                        }
                                    }
                                    else {
                                        alt4=13;
                                    }
                                    }
                                    break;
                                case 'l':
                                    {
                                    int LA4_17 = input.LA(8);

                                    if ( (LA4_17=='i') ) {
                                        int LA4_22 = input.LA(9);

                                        if ( (LA4_22=='n') ) {
                                            int LA4_28 = input.LA(10);

                                            if ( (LA4_28=='k') ) {
                                                int LA4_34 = input.LA(11);

                                                if ( ((LA4_34 >= '-' && LA4_34 <= ':')||(LA4_34 >= '@' && LA4_34 <= 'Z')||LA4_34=='_'||(LA4_34 >= 'a' && LA4_34 <= 'z')) ) {
                                                    alt4=13;
                                                }
                                                else {
                                                    alt4=6;
                                                }
                                            }
                                            else {
                                                alt4=13;
                                            }
                                        }
                                        else {
                                            alt4=13;
                                        }
                                    }
                                    else {
                                        alt4=13;
                                    }
                                    }
                                    break;
                                case 'm':
                                    {
                                    int LA4_18 = input.LA(8);

                                    if ( (LA4_18=='o') ) {
                                        int LA4_23 = input.LA(9);

                                        if ( (LA4_23=='d') ) {
                                            int LA4_29 = input.LA(10);

                                            if ( (LA4_29=='e') ) {
                                                int LA4_35 = input.LA(11);

                                                if ( (LA4_35=='l') ) {
                                                    int LA4_43 = input.LA(12);

                                                    if ( ((LA4_43 >= '-' && LA4_43 <= ':')||(LA4_43 >= '@' && LA4_43 <= 'Z')||LA4_43=='_'||(LA4_43 >= 'a' && LA4_43 <= 'z')) ) {
                                                        alt4=13;
                                                    }
                                                    else {
                                                        alt4=7;
                                                    }
                                                }
                                                else {
                                                    alt4=13;
                                                }
                                            }
                                            else {
                                                alt4=13;
                                            }
                                        }
                                        else {
                                            alt4=13;
                                        }
                                    }
                                    else {
                                        alt4=13;
                                    }
                                    }
                                    break;
                                case 'n':
                                    {
                                    switch ( input.LA(8) ) {
                                    case 'b':
                                        {
                                        int LA4_24 = input.LA(9);

                                        if ( (LA4_24=='_') ) {
                                            switch ( input.LA(10) ) {
                                            case 'e':
                                                {
                                                int LA4_36 = input.LA(11);

                                                if ( (LA4_36=='d') ) {
                                                    int LA4_44 = input.LA(12);

                                                    if ( (LA4_44=='g') ) {
                                                        int LA4_50 = input.LA(13);

                                                        if ( (LA4_50=='e') ) {
                                                            int LA4_53 = input.LA(14);

                                                            if ( ((LA4_53 >= '-' && LA4_53 <= ':')||(LA4_53 >= '@' && LA4_53 <= 'Z')||LA4_53=='_'||(LA4_53 >= 'a' && LA4_53 <= 'z')) ) {
                                                                alt4=13;
                                                            }
                                                            else {
                                                                alt4=8;
                                                            }
                                                        }
                                                        else {
                                                            alt4=13;
                                                        }
                                                    }
                                                    else {
                                                        alt4=13;
                                                    }
                                                }
                                                else {
                                                    alt4=13;
                                                }
                                                }
                                                break;
                                            case 'n':
                                                {
                                                int LA4_37 = input.LA(11);

                                                if ( (LA4_37=='o') ) {
                                                    int LA4_45 = input.LA(12);

                                                    if ( (LA4_45=='d') ) {
                                                        int LA4_51 = input.LA(13);

                                                        if ( (LA4_51=='e') ) {
                                                            int LA4_54 = input.LA(14);

                                                            if ( ((LA4_54 >= '-' && LA4_54 <= ':')||(LA4_54 >= '@' && LA4_54 <= 'Z')||LA4_54=='_'||(LA4_54 >= 'a' && LA4_54 <= 'z')) ) {
                                                                alt4=13;
                                                            }
                                                            else {
                                                                alt4=9;
                                                            }
                                                        }
                                                        else {
                                                            alt4=13;
                                                        }
                                                    }
                                                    else {
                                                        alt4=13;
                                                    }
                                                }
                                                else {
                                                    alt4=13;
                                                }
                                                }
                                                break;
                                            case 'p':
                                                {
                                                int LA4_38 = input.LA(11);

                                                if ( (LA4_38=='r') ) {
                                                    int LA4_46 = input.LA(12);

                                                    if ( (LA4_46=='o') ) {
                                                        int LA4_52 = input.LA(13);

                                                        if ( (LA4_52=='p') ) {
                                                            int LA4_55 = input.LA(14);

                                                            if ( ((LA4_55 >= '-' && LA4_55 <= ':')||(LA4_55 >= '@' && LA4_55 <= 'Z')||LA4_55=='_'||(LA4_55 >= 'a' && LA4_55 <= 'z')) ) {
                                                                alt4=13;
                                                            }
                                                            else {
                                                                alt4=10;
                                                            }
                                                        }
                                                        else {
                                                            alt4=13;
                                                        }
                                                    }
                                                    else {
                                                        alt4=13;
                                                    }
                                                }
                                                else {
                                                    alt4=13;
                                                }
                                                }
                                                break;
                                            default:
                                                alt4=13;
                                            }

                                        }
                                        else {
                                            alt4=13;
                                        }
                                        }
                                        break;
                                    case 'o':
                                        {
                                        int LA4_25 = input.LA(9);

                                        if ( (LA4_25=='d') ) {
                                            int LA4_31 = input.LA(10);

                                            if ( (LA4_31=='e') ) {
                                                int LA4_39 = input.LA(11);

                                                if ( ((LA4_39 >= '-' && LA4_39 <= ':')||(LA4_39 >= '@' && LA4_39 <= 'Z')||LA4_39=='_'||(LA4_39 >= 'a' && LA4_39 <= 'z')) ) {
                                                    alt4=13;
                                                }
                                                else {
                                                    alt4=11;
                                                }
                                            }
                                            else {
                                                alt4=13;
                                            }
                                        }
                                        else {
                                            alt4=13;
                                        }
                                        }
                                        break;
                                    default:
                                        alt4=13;
                                    }

                                    }
                                    break;
                                case 'p':
                                    {
                                    int LA4_20 = input.LA(8);

                                    if ( (LA4_20=='r') ) {
                                        int LA4_26 = input.LA(9);

                                        if ( (LA4_26=='o') ) {
                                            int LA4_32 = input.LA(10);

                                            if ( (LA4_32=='p') ) {
                                                int LA4_40 = input.LA(11);

                                                if ( ((LA4_40 >= '-' && LA4_40 <= ':')||(LA4_40 >= '@' && LA4_40 <= 'Z')||LA4_40=='_'||(LA4_40 >= 'a' && LA4_40 <= 'z')) ) {
                                                    alt4=13;
                                                }
                                                else {
                                                    alt4=12;
                                                }
                                            }
                                            else {
                                                alt4=13;
                                            }
                                        }
                                        else {
                                            alt4=13;
                                        }
                                    }
                                    else {
                                        alt4=13;
                                    }
                                    }
                                    break;
                                default:
                                    alt4=13;
                                }

                            }
                            else {
                                alt4=13;
                            }
                        }
                        else {
                            alt4=13;
                        }
                    }
                    else {
                        alt4=13;
                    }
                }
                else {
                    alt4=13;
                }
            }
            else {
                alt4=13;
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
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt4=13;
            }
            break;
        case '\n':
        case '\r':
            {
            alt4=14;
            }
            break;
        case '\t':
        case '\f':
        case ' ':
            {
            alt4=15;
            }
            break;
        case '\"':
            {
            alt4=16;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 4, 0, input);

            throw nvae;

        }

        switch (alt4) {
            case 1 :
                // Aspt.g:1:10: T__8
                {
                mT__8(); 


                }
                break;
            case 2 :
                // Aspt.g:1:15: T__9
                {
                mT__9(); 


                }
                break;
            case 3 :
                // Aspt.g:1:20: T__10
                {
                mT__10(); 


                }
                break;
            case 4 :
                // Aspt.g:1:26: T__11
                {
                mT__11(); 


                }
                break;
            case 5 :
                // Aspt.g:1:32: T__12
                {
                mT__12(); 


                }
                break;
            case 6 :
                // Aspt.g:1:38: T__13
                {
                mT__13(); 


                }
                break;
            case 7 :
                // Aspt.g:1:44: T__14
                {
                mT__14(); 


                }
                break;
            case 8 :
                // Aspt.g:1:50: T__15
                {
                mT__15(); 


                }
                break;
            case 9 :
                // Aspt.g:1:56: T__16
                {
                mT__16(); 


                }
                break;
            case 10 :
                // Aspt.g:1:62: T__17
                {
                mT__17(); 


                }
                break;
            case 11 :
                // Aspt.g:1:68: T__18
                {
                mT__18(); 


                }
                break;
            case 12 :
                // Aspt.g:1:74: T__19
                {
                mT__19(); 


                }
                break;
            case 13 :
                // Aspt.g:1:80: TEXT
                {
                mTEXT(); 


                }
                break;
            case 14 :
                // Aspt.g:1:85: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 15 :
                // Aspt.g:1:95: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 16 :
                // Aspt.g:1:106: QUOTED_34_34_92
                {
                mQUOTED_34_34_92(); 


                }
                break;

        }

    }


 

}