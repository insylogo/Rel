/* Generated By:JavaCC: Do not edit this line. ResponseParserTokenManager.java */
package org.reldb.rel.client.parser.core;
import org.reldb.rel.client.parser.ResponseHandler;
import org.reldb.rel.client.parser.ResponseAdapter;
import org.reldb.rel.utilities.StringUtils;

/** Token Manager. */
public class ResponseParserTokenManager implements ResponseParserConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 9:
         jjmatchedKind = 2;
         return jjMoveNfa_0(11, 0);
      case 10:
         jjmatchedKind = 3;
         return jjMoveNfa_0(11, 0);
      case 12:
         jjmatchedKind = 5;
         return jjMoveNfa_0(11, 0);
      case 13:
         jjmatchedKind = 4;
         return jjMoveNfa_0(11, 0);
      case 32:
         jjmatchedKind = 1;
         return jjMoveNfa_0(11, 0);
      case 40:
         jjmatchedKind = 28;
         return jjMoveNfa_0(11, 0);
      case 41:
         jjmatchedKind = 29;
         return jjMoveNfa_0(11, 0);
      case 44:
         jjmatchedKind = 33;
         return jjMoveNfa_0(11, 0);
      case 58:
         jjmatchedKind = 34;
         return jjMoveNfa_0(11, 0);
      case 59:
         jjmatchedKind = 32;
         return jjMoveNfa_0(11, 0);
      case 60:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 65:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 69:
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 70:
         return jjMoveStringLiteralDfa1_0(0x800L);
      case 79:
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 82:
         return jjMoveStringLiteralDfa1_0(0x21000L);
      case 84:
         return jjMoveStringLiteralDfa1_0(0x6000L);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x800L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x21000L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x6000L);
      case 123:
         jjmatchedKind = 30;
         return jjMoveNfa_0(11, 0);
      case 125:
         jjmatchedKind = 31;
         return jjMoveNfa_0(11, 0);
      default :
         return jjMoveNfa_0(11, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(11, 0);
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa2_0(active0, 0x800L);
      case 69:
         return jjMoveStringLiteralDfa2_0(active0, 0x21400L);
      case 78:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000L);
      case 80:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000L);
      case 82:
         return jjMoveStringLiteralDfa2_0(active0, 0x2200L);
      case 85:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000L);
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x800L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x21400L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000L);
      case 112:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x2200L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000L);
      default :
         break;
   }
   return jjMoveNfa_0(11, 1);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjMoveNfa_0(11, 1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(11, 1);
   }
   switch(curChar)
   {
      case 68:
         if ((active0 & 0x10000L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 2;
         }
         break;
      case 69:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000L);
      case 76:
         return jjMoveStringLiteralDfa3_0(active0, 0x1800L);
      case 79:
         return jjMoveStringLiteralDfa3_0(active0, 0x400L);
      case 80:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000L);
      case 82:
         return jjMoveStringLiteralDfa3_0(active0, 0x200L);
      case 84:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000L);
      case 85:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000L);
      case 100:
         if ((active0 & 0x10000L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 2;
         }
         break;
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x1800L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x400L);
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x200L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000L);
      default :
         break;
   }
   return jjMoveNfa_0(11, 2);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjMoveNfa_0(11, 2);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(11, 2);
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa4_0(active0, 0x1200L);
      case 69:
         if ((active0 & 0x2000L) != 0L)
         {
            jjmatchedKind = 13;
            jjmatchedPos = 3;
         }
         break;
      case 76:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000L);
      case 82:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000L);
      case 83:
         return jjMoveStringLiteralDfa4_0(active0, 0x800L);
      case 84:
         return jjMoveStringLiteralDfa4_0(active0, 0x400L);
      case 85:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000L);
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x1200L);
      case 101:
         if ((active0 & 0x2000L) != 0L)
         {
            jjmatchedKind = 13;
            jjmatchedPos = 3;
         }
         break;
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000L);
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x800L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x400L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000L);
      default :
         break;
   }
   return jjMoveNfa_0(11, 3);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjMoveNfa_0(11, 3);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(11, 3);
   }
   switch(curChar)
   {
      case 62:
         if ((active0 & 0x400L) != 0L)
         {
            jjmatchedKind = 10;
            jjmatchedPos = 4;
         }
         break;
      case 65:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000L);
      case 69:
         if ((active0 & 0x800L) != 0L)
         {
            jjmatchedKind = 11;
            jjmatchedPos = 4;
         }
         else if ((active0 & 0x4000L) != 0L)
         {
            jjmatchedKind = 14;
            jjmatchedPos = 4;
         }
         break;
      case 82:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000L);
      case 84:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000L);
      case 89:
         if ((active0 & 0x200L) != 0L)
         {
            jjmatchedKind = 9;
            jjmatchedPos = 4;
         }
         break;
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000L);
      case 101:
         if ((active0 & 0x800L) != 0L)
         {
            jjmatchedKind = 11;
            jjmatchedPos = 4;
         }
         else if ((active0 & 0x4000L) != 0L)
         {
            jjmatchedKind = 14;
            jjmatchedPos = 4;
         }
         break;
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000L);
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000L);
      case 121:
         if ((active0 & 0x200L) != 0L)
         {
            jjmatchedKind = 9;
            jjmatchedPos = 4;
         }
         break;
      default :
         break;
   }
   return jjMoveNfa_0(11, 4);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjMoveNfa_0(11, 4);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(11, 4);
   }
   switch(curChar)
   {
      case 73:
         return jjMoveStringLiteralDfa6_0(active0, 0x1000L);
      case 78:
         return jjMoveStringLiteralDfa6_0(active0, 0x20000L);
      case 84:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000L);
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0x1000L);
      case 110:
         return jjMoveStringLiteralDfa6_0(active0, 0x20000L);
      case 116:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000L);
      default :
         break;
   }
   return jjMoveNfa_0(11, 5);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjMoveNfa_0(11, 5);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(11, 5);
   }
   switch(curChar)
   {
      case 79:
         return jjMoveStringLiteralDfa7_0(active0, 0x9000L);
      case 83:
         if ((active0 & 0x20000L) != 0L)
         {
            jjmatchedKind = 17;
            jjmatchedPos = 6;
         }
         break;
      case 111:
         return jjMoveStringLiteralDfa7_0(active0, 0x9000L);
      case 115:
         if ((active0 & 0x20000L) != 0L)
         {
            jjmatchedKind = 17;
            jjmatchedPos = 6;
         }
         break;
      default :
         break;
   }
   return jjMoveNfa_0(11, 6);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjMoveNfa_0(11, 6);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(11, 6);
   }
   switch(curChar)
   {
      case 78:
         if ((active0 & 0x1000L) != 0L)
         {
            jjmatchedKind = 12;
            jjmatchedPos = 7;
         }
         break;
      case 82:
         if ((active0 & 0x8000L) != 0L)
         {
            jjmatchedKind = 15;
            jjmatchedPos = 7;
         }
         break;
      case 110:
         if ((active0 & 0x1000L) != 0L)
         {
            jjmatchedKind = 12;
            jjmatchedPos = 7;
         }
         break;
      case 114:
         if ((active0 & 0x8000L) != 0L)
         {
            jjmatchedKind = 15;
            jjmatchedPos = 7;
         }
         break;
      default :
         break;
   }
   return jjMoveNfa_0(11, 7);
}
static final long[] jjbitVec0 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec3 = {
   0x1ff00000fffffffeL, 0xffffffffffffc000L, 0xffffffffL, 0x600000000000000L
};
static final long[] jjbitVec4 = {
   0x0L, 0x0L, 0x0L, 0xff7fffffff7fffffL
};
static final long[] jjbitVec5 = {
   0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec6 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffL, 0x0L
};
static final long[] jjbitVec7 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0x0L, 0x0L
};
static final long[] jjbitVec8 = {
   0x3fffffffffffL, 0x0L, 0x0L, 0x0L
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int strKind = jjmatchedKind;
   int strPos = jjmatchedPos;
   int seenUpto;
   input_stream.backup(seenUpto = curPos + 1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { throw new Error("Internal Error"); }
   curPos = 0;
   int startsAt = 0;
   jjnewStateCnt = 81;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 11:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(0, 6);
                  else if ((0x280000000000L & l) != 0L)
                     jjCheckNAddStates(7, 11);
                  else if (curChar == 47)
                     jjAddStates(12, 14);
                  else if (curChar == 36)
                  {
                     if (kind > 25)
                        kind = 25;
                     jjCheckNAdd(39);
                  }
                  else if (curChar == 39)
                     jjCheckNAddStates(15, 17);
                  else if (curChar == 34)
                     jjCheckNAddStates(18, 20);
                  else if (curChar == 46)
                     jjCheckNAdd(12);
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 18)
                        kind = 18;
                     jjCheckNAddTwoStates(1, 2);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 18)
                        kind = 18;
                     jjCheckNAddStates(21, 23);
                  }
                  break;
               case 0:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 18)
                     kind = 18;
                  jjCheckNAddTwoStates(1, 2);
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 18)
                     kind = 18;
                  jjCheckNAddTwoStates(1, 2);
                  break;
               case 12:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAddStates(24, 26);
                  break;
               case 14:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(15);
                  break;
               case 15:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAddTwoStates(15, 16);
                  break;
               case 20:
                  if (curChar == 34)
                     jjCheckNAddStates(18, 20);
                  break;
               case 21:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(18, 20);
                  break;
               case 23:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAddStates(18, 20);
                  break;
               case 24:
                  if (curChar == 34 && kind > 24)
                     kind = 24;
                  break;
               case 25:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(27, 30);
                  break;
               case 26:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(18, 20);
                  break;
               case 27:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 28;
                  break;
               case 28:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(26);
                  break;
               case 29:
                  if (curChar == 39)
                     jjCheckNAddStates(15, 17);
                  break;
               case 30:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                     jjCheckNAddStates(15, 17);
                  break;
               case 32:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAddStates(15, 17);
                  break;
               case 33:
                  if (curChar == 39 && kind > 24)
                     kind = 24;
                  break;
               case 34:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(31, 34);
                  break;
               case 35:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(15, 17);
                  break;
               case 36:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 37;
                  break;
               case 37:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(35);
                  break;
               case 38:
                  if (curChar != 36)
                     break;
                  if (kind > 25)
                     kind = 25;
                  jjCheckNAdd(39);
                  break;
               case 39:
                  if ((0x3ff401800000000L & l) == 0L)
                     break;
                  if (kind > 25)
                     kind = 25;
                  jjCheckNAdd(39);
                  break;
               case 40:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(0, 6);
                  break;
               case 41:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(41, 42);
                  break;
               case 42:
                  if (curChar != 46)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAddStates(35, 37);
                  break;
               case 43:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAddStates(35, 37);
                  break;
               case 45:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(46);
                  break;
               case 46:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAddTwoStates(46, 16);
                  break;
               case 47:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(47, 48);
                  break;
               case 49:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(50);
                  break;
               case 50:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAddTwoStates(50, 16);
                  break;
               case 51:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(38, 40);
                  break;
               case 53:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(54);
                  break;
               case 54:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(54, 16);
                  break;
               case 55:
                  if (curChar != 48)
                     break;
                  if (kind > 18)
                     kind = 18;
                  jjCheckNAddStates(21, 23);
                  break;
               case 57:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 18)
                     kind = 18;
                  jjCheckNAddTwoStates(57, 2);
                  break;
               case 58:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 18)
                     kind = 18;
                  jjCheckNAddTwoStates(58, 2);
                  break;
               case 59:
                  if (curChar == 47)
                     jjAddStates(12, 14);
                  break;
               case 60:
                  if (curChar == 47)
                     jjCheckNAddStates(41, 43);
                  break;
               case 61:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  break;
               case 62:
                  if ((0x2400L & l) != 0L && kind > 6)
                     kind = 6;
                  break;
               case 63:
                  if (curChar == 10 && kind > 6)
                     kind = 6;
                  break;
               case 64:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 63;
                  break;
               case 65:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(66, 67);
                  break;
               case 66:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(66, 67);
                  break;
               case 67:
                  if (curChar == 42)
                     jjCheckNAddStates(44, 46);
                  break;
               case 68:
                  if ((0xffff7bffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(69, 67);
                  break;
               case 69:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(69, 67);
                  break;
               case 70:
                  if (curChar == 47 && kind > 7)
                     kind = 7;
                  break;
               case 71:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 65;
                  break;
               case 72:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(73, 74);
                  break;
               case 73:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(73, 74);
                  break;
               case 74:
                  if (curChar == 42)
                     jjCheckNAddStates(47, 49);
                  break;
               case 75:
                  if ((0xffff7bffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(76, 74);
                  break;
               case 76:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(76, 74);
                  break;
               case 77:
                  if (curChar == 47 && kind > 8)
                     kind = 8;
                  break;
               case 78:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAddStates(7, 11);
                  break;
               case 79:
                  if (curChar == 48)
                     jjCheckNAdd(56);
                  break;
               case 80:
                  if (curChar != 48)
                     break;
                  if (kind > 18)
                     kind = 18;
                  jjCheckNAddTwoStates(58, 2);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 11:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 25)
                        kind = 25;
                     jjCheckNAdd(39);
                  }
                  if (curChar == 78)
                     jjstateSet[jjnewStateCnt++] = 18;
                  else if (curChar == 73)
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 2:
                  if ((0x100000001000L & l) != 0L && kind > 18)
                     kind = 18;
                  break;
               case 3:
                  if (curChar == 121 && kind > 22)
                     kind = 22;
                  break;
               case 4:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 3;
                  break;
               case 5:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 6:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 7:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 8:
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 9:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 8;
                  break;
               case 10:
                  if (curChar == 73)
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 13:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(50, 51);
                  break;
               case 16:
                  if ((0x5000000050L & l) != 0L && kind > 22)
                     kind = 22;
                  break;
               case 17:
                  if (curChar == 78 && kind > 22)
                     kind = 22;
                  break;
               case 18:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 17;
                  break;
               case 19:
                  if (curChar == 78)
                     jjstateSet[jjnewStateCnt++] = 18;
                  break;
               case 21:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(18, 20);
                  break;
               case 22:
                  if (curChar == 92)
                     jjAddStates(52, 54);
                  break;
               case 23:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAddStates(18, 20);
                  break;
               case 30:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(15, 17);
                  break;
               case 31:
                  if (curChar == 92)
                     jjAddStates(55, 57);
                  break;
               case 32:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAddStates(15, 17);
                  break;
               case 38:
               case 39:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 25)
                     kind = 25;
                  jjCheckNAdd(39);
                  break;
               case 44:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(58, 59);
                  break;
               case 48:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(60, 61);
                  break;
               case 52:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(62, 63);
                  break;
               case 56:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(57);
                  break;
               case 57:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 18)
                     kind = 18;
                  jjCheckNAddTwoStates(57, 2);
                  break;
               case 61:
                  jjAddStates(41, 43);
                  break;
               case 66:
                  jjCheckNAddTwoStates(66, 67);
                  break;
               case 68:
               case 69:
                  jjCheckNAddTwoStates(69, 67);
                  break;
               case 73:
                  jjCheckNAddTwoStates(73, 74);
                  break;
               case 75:
               case 76:
                  jjCheckNAddTwoStates(76, 74);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 11:
               case 39:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 25)
                     kind = 25;
                  jjCheckNAdd(39);
                  break;
               case 21:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjAddStates(18, 20);
                  break;
               case 30:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjAddStates(15, 17);
                  break;
               case 61:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjAddStates(41, 43);
                  break;
               case 66:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(66, 67);
                  break;
               case 68:
               case 69:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(69, 67);
                  break;
               case 73:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(73, 74);
                  break;
               case 75:
               case 76:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(76, 74);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 81 - (jjnewStateCnt = startsAt)))
         break;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { break; }
   }
   if (jjmatchedPos > strPos)
      return curPos;

   int toRet = Math.max(curPos, seenUpto);

   if (curPos < toRet)
      for (i = toRet - Math.min(curPos, seenUpto); i-- > 0; )
         try { curChar = input_stream.readChar(); }
         catch(java.io.IOException e) { throw new Error("Internal Error : Please send a bug report."); }

   if (jjmatchedPos < strPos)
   {
      jjmatchedKind = strKind;
      jjmatchedPos = strPos;
   }
   else if (jjmatchedPos == strPos && jjmatchedKind > strKind)
      jjmatchedKind = strKind;

   return toRet;
}
static final int[] jjnextStates = {
   41, 42, 47, 48, 51, 52, 16, 0, 79, 80, 41, 10, 60, 71, 72, 30, 
   31, 33, 21, 22, 24, 56, 58, 2, 12, 13, 16, 21, 22, 26, 24, 30, 
   31, 35, 33, 43, 44, 16, 51, 52, 16, 61, 62, 64, 67, 68, 70, 74, 
   75, 77, 14, 15, 23, 25, 27, 32, 34, 36, 45, 46, 49, 50, 53, 54, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      default :
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}
private static final boolean jjCanMove_1(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec4[i2] & l2) != 0L);
      case 48:
         return ((jjbitVec5[i2] & l2) != 0L);
      case 49:
         return ((jjbitVec6[i2] & l2) != 0L);
      case 51:
         return ((jjbitVec7[i2] & l2) != 0L);
      case 61:
         return ((jjbitVec8[i2] & l2) != 0L);
      default :
         if ((jjbitVec3[i1] & l1) != 0L)
            return true;
         return false;
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, "\50", "\51", "\173", "\175", "\73", "\54", "\72", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x7f347fe01L, 
};
static final long[] jjtoSkip = {
   0x1feL, 
};
static final long[] jjtoSpecial = {
   0x1c0L, 
};
protected JavaCharStream input_stream;
private final int[] jjrounds = new int[81];
private final int[] jjstateSet = new int[162];
protected char curChar;
/** Constructor. */
public ResponseParserTokenManager(JavaCharStream stream){
   if (JavaCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public ResponseParserTokenManager(JavaCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(JavaCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 81; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(JavaCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }

   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         matchedToken.specialToken = specialToken;
         return matchedToken;
      }
      else
      {
         if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
         {
            matchedToken = jjFillToken();
            if (specialToken == null)
               specialToken = matchedToken;
            else
            {
               matchedToken.specialToken = specialToken;
               specialToken = (specialToken.next = matchedToken);
            }
         }
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
