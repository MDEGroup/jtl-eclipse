// $ANTLR 3.4

	package ASPMM.resource.aspmm.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AspmmLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__7=7;
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
    public static final int LINEBREAK=4;
    public static final int TEXT=5;
    public static final int WHITESPACE=6;

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

    public AspmmLexer() {} 
    public AspmmLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public AspmmLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Aspmm.g"; }

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspmm.g:15:6: ( '(' )
            // Aspmm.g:15:8: '('
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
    // $ANTLR end "T__7"

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspmm.g:16:6: ( ')' )
            // Aspmm.g:16:8: ')'
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
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspmm.g:17:6: ( ',' )
            // Aspmm.g:17:8: ','
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
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspmm.g:18:7: ( '.' )
            // Aspmm.g:18:9: '.'
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspmm.g:19:7: ( 'association' )
            // Aspmm.g:19:9: 'association'
            {
            match("association"); 



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
            // Aspmm.g:20:7: ( 'composition' )
            // Aspmm.g:20:9: 'composition'
            {
            match("composition"); 



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
            // Aspmm.g:21:7: ( 'generalization' )
            // Aspmm.g:21:9: 'generalization'
            {
            match("generalization"); 



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
            // Aspmm.g:22:7: ( 'metaedge' )
            // Aspmm.g:22:9: 'metaedge'
            {
            match("metaedge"); 



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
            // Aspmm.g:23:7: ( 'metamodel' )
            // Aspmm.g:23:9: 'metamodel'
            {
            match("metamodel"); 



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
            // Aspmm.g:24:7: ( 'metanode' )
            // Aspmm.g:24:9: 'metanode'
            {
            match("metanode"); 



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
            // Aspmm.g:25:7: ( 'metaprop' )
            // Aspmm.g:25:9: 'metaprop'
            {
            match("metaprop"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspmm.g:1394:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // Aspmm.g:1395:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // Aspmm.g:1395:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Aspmm.g:1395:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Aspmm.g:1395:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='-'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Aspmm.g:
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

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Aspmm.g:1397:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Aspmm.g:1398:2: ( ( ' ' | '\\t' | '\\f' ) )
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
            // Aspmm.g:1401:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Aspmm.g:1402:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Aspmm.g:1402:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Aspmm.g:1402:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Aspmm.g:1402:3: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // Aspmm.g:1402:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Aspmm.g:1402:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Aspmm.g:1402:20: '\\n'
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
        // Aspmm.g:1:8: ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | TEXT | WHITESPACE | LINEBREAK )
        int alt3=14;
        alt3 = dfa3.predict(input);
        switch (alt3) {
            case 1 :
                // Aspmm.g:1:10: T__7
                {
                mT__7(); 


                }
                break;
            case 2 :
                // Aspmm.g:1:15: T__8
                {
                mT__8(); 


                }
                break;
            case 3 :
                // Aspmm.g:1:20: T__9
                {
                mT__9(); 


                }
                break;
            case 4 :
                // Aspmm.g:1:25: T__10
                {
                mT__10(); 


                }
                break;
            case 5 :
                // Aspmm.g:1:31: T__11
                {
                mT__11(); 


                }
                break;
            case 6 :
                // Aspmm.g:1:37: T__12
                {
                mT__12(); 


                }
                break;
            case 7 :
                // Aspmm.g:1:43: T__13
                {
                mT__13(); 


                }
                break;
            case 8 :
                // Aspmm.g:1:49: T__14
                {
                mT__14(); 


                }
                break;
            case 9 :
                // Aspmm.g:1:55: T__15
                {
                mT__15(); 


                }
                break;
            case 10 :
                // Aspmm.g:1:61: T__16
                {
                mT__16(); 


                }
                break;
            case 11 :
                // Aspmm.g:1:67: T__17
                {
                mT__17(); 


                }
                break;
            case 12 :
                // Aspmm.g:1:73: TEXT
                {
                mTEXT(); 


                }
                break;
            case 13 :
                // Aspmm.g:1:78: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 14 :
                // Aspmm.g:1:89: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\5\uffff\4\11\3\uffff\44\11\1\67\1\11\1\71\1\72\3\11\1\uffff\1\76"+
        "\2\uffff\3\11\1\uffff\1\102\1\103\1\11\2\uffff\2\11\1\107\1\uffff";
    static final String DFA3_eofS =
        "\110\uffff";
    static final String DFA3_minS =
        "\1\11\4\uffff\1\163\1\157\2\145\3\uffff\1\163\1\155\1\156\1\164"+
        "\1\157\1\160\1\145\1\141\1\143\1\157\1\162\1\145\1\151\1\163\1\141"+
        "\1\144\2\157\1\162\1\141\1\151\1\154\1\147\2\144\1\157\2\164\1\151"+
        "\3\145\1\160\2\151\1\172\1\55\1\154\2\55\2\157\1\141\1\uffff\1\55"+
        "\2\uffff\2\156\1\164\1\uffff\2\55\1\151\2\uffff\1\157\1\156\1\55"+
        "\1\uffff";
    static final String DFA3_maxS =
        "\1\172\4\uffff\1\163\1\157\2\145\3\uffff\1\163\1\155\1\156\1\164"+
        "\1\157\1\160\1\145\1\141\1\143\1\157\1\162\1\160\1\151\1\163\1\141"+
        "\1\144\2\157\1\162\1\141\1\151\1\154\1\147\2\144\1\157\2\164\1\151"+
        "\3\145\1\160\2\151\2\172\1\154\2\172\2\157\1\141\1\uffff\1\172\2"+
        "\uffff\2\156\1\164\1\uffff\2\172\1\151\2\uffff\1\157\1\156\1\172"+
        "\1\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\4\uffff\1\14\1\15\1\16\53\uffff\1\10\1"+
        "\uffff\1\12\1\13\3\uffff\1\11\3\uffff\1\5\1\6\3\uffff\1\7";
    static final String DFA3_specialS =
        "\110\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\12\1\13\1\uffff\1\12\1\13\22\uffff\1\12\7\uffff\1\1\1\2\2"+
            "\uffff\1\3\1\11\1\4\1\uffff\12\11\7\uffff\32\11\4\uffff\1\11"+
            "\1\uffff\1\5\1\11\1\6\3\11\1\7\5\11\1\10\15\11",
            "",
            "",
            "",
            "",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "",
            "",
            "",
            "\1\20",
            "\1\21",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33\7\uffff\1\34\1\35\1\uffff\1\36",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
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
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\70",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\73",
            "\1\74",
            "\1\75",
            "",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "",
            "",
            "\1\77",
            "\1\100",
            "\1\101",
            "",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\104",
            "",
            "",
            "\1\105",
            "\1\106",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            ""
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
            return "1:1: Tokens : ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | TEXT | WHITESPACE | LINEBREAK );";
        }
    }
 

}