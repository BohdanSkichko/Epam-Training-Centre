package chapter7.variantb.task1;

import java.util.*;

import static java.lang.Math.min;


public class Text {

    private static final String PARAGRAPH_SPLIT = "(\n)";
    private final List<Paragraph> paragraphList = new ArrayList<>();

    public Text(String text) {
        parseText(text);
    }

    public void parseText(String input) {
        String[] paragraphs = input.split(PARAGRAPH_SPLIT);
        for (String paragraph : paragraphs) {
            paragraphList.add(new Paragraph(paragraph));
        }
    }

    public List<String> getRepeatedWord() {
        List<String> repeatedWord = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                repeatedWord.add(sentence.findMaxRepeatedWord());
            }
        }
        return repeatedWord;
    }


    public int getSentenceWithRepeatedWords() {
        int count = 0;
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                if (sentence.isContainsRepeatedWord()) {
                    count++;
                }
            }
        }
        return count;

    }

    public void printSortedFirstLetterWord() {
        List<SentenceElement> wordList = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                for (SentenceElement sentenceElement : sentence.getSentenceElements())
                    if (sentenceElement.isWord())
                        wordList.add(sentenceElement);
            }
        }
        wordList.sort(Comparator.comparing(word -> word.getContent().toLowerCase()));
        String letter = wordList.get(0).getContent().substring(0, 1);
        boolean redline = true;
        for (SentenceElement word : wordList) {
            if (!word.getContent().substring(0, 1).equalsIgnoreCase(letter)) {
                redline = true;
                letter = word.getContent().substring(0, 1);
            }
            if (redline) {
                System.out.print("\n\t" + word + " ");
            } else {
                System.out.print(word + " ");
            }
            redline = false;
        }
        System.out.println();
    }

    public List<Word> getSortedPercentageVowelsLetters() {
        List<Word> wordList = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                for (SentenceElement sentenceElement : sentence.getSentenceElements())
                    if (sentenceElement.isWord())
                        wordList.add((Word) sentenceElement);
            }
        }
        wordList.sort(Comparator.comparing(Word::getPercentageVowels));
        return wordList;
    }

    public List<Word> getSortedSecondConsonantLetter() {
        List<Word> wordList = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                for (SentenceElement word : sentence.getSentenceElements()) {
                    if (word.isWord() && ((Word) word).isFirstVowelLetter()) {
                        wordList.add((Word) word);
                    }
                }
            }
        }
        wordList.sort(Comparator.comparing(Word::getFirstConsonantLetter));
        return wordList;
    }

    public Set<SentenceElement> getUniqueWordsInterrogateSentences(int lengthWord) {
        Set<SentenceElement> wordList = new HashSet<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                if (sentence.isInterrogativeSentence()) {
                    for (SentenceElement word : sentence.getSentenceElements())
                        if (word.isWord() && word.getContent().length() == lengthWord) {
                            wordList.add(word);
                        }
                }
            }
        }
        return wordList;
    }

    public List<Sentence> removeVowelStartingWords(int lengthWord) {
        List<Sentence> sentences = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                sentences.add(sentence.removeWordFirstVowelLetter(lengthWord));
            }
        }
        return sentences;
    }

    public List<Sentence> swapFirstAndLastWordSentence() {
        List<Sentence> sentences = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                sentences.add(sentence.swapFirstAndLastWord());
            }
        }
        return sentences;
    }


    public List<Sentence> sortSentenceQuantityWords() {
        List<Sentence> sentences = new ArrayList<>();
        for (Paragraph paragraph : paragraphList) {
            sentences.addAll(paragraph.getSentenceList());
        }
        sentences.sort(Comparator.comparing(sentence -> sentence.getSentenceElements().size()));
        return sentences;

    }


    public String getUniqueWord() {
        List<String> referenceWord = new ArrayList<>();
        for (int i = 0; i < getParagraphList().get(0).getSentenceList().get(0).getSentenceElements().size(); i++) {
            if (paragraphList.get(0).getSentenceList().get(0).getSentenceElements().get(i).isWord())
                referenceWord.add(String.valueOf(paragraphList.get(0).getSentenceList().get(0).getSentenceElements().get(i)));
        }
        Set<String> wordSet = new HashSet<>();
        for (Paragraph paragraph : paragraphList) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                if (sentence == paragraphList.get(0).getSentenceList().get(0)) continue;
                for (SentenceElement word : sentence.getSentenceElements()) {
                    wordSet.add(String.valueOf(word).toLowerCase());
                }
            }
        }
        for (String word : referenceWord) {
            if (!wordSet.contains(word.toLowerCase())) {
                return word;
            }
        }
        return null;
    }

    public List<Paragraph> getParagraphList() {
        return paragraphList;
    }

    public void printLongestPalindromicString() {
        String text = paragraphList.toString();
        int N = text.length();
        if (N == 0)
            return;
        N = 2 * N + 1; // Position count
        int[] L = new int[N + 1]; // LPS Length Array
        L[0] = 0;
        L[1] = 1;
        int C = 1; // centerPosition
        int R = 2; // centerRightPosition
        int i = 0; // currentRightPosition
        int iMirror; // currentLeftPosition
        int maxLPSLength = 0;
        int maxLPSCenterPosition = 0;
        int start = -1;
        int end = -1;
        int diff = -1;

        // Uncomment it to print LPS Length array
        // printf("%d %d ", L[0], L[1]);
        for (i = 2; i < N; i++) {

            // get currentLeftPosition iMirror
            // for currentRightPosition i
            iMirror = 2 * C - i;
            L[i] = 0;
            diff = R - i;

            // If currentRightPosition i is within
            // centerRightPosition R
            if (diff > 0)
                L[i] = Math.min(L[iMirror], diff);

            // Attempt to expand palindrome centered at
            // currentRightPosition i. Here for odd positions,
            // we compare characters and if match then
            // increment LPS Length by ONE. If even position,
            // we just increment LPS by ONE without
            // any character comparison
            while (((i + L[i]) + 1 < N && (i - L[i]) > 0) &&
                    (((i + L[i] + 1) % 2 == 0) ||
                            (text.charAt((i + L[i] + 1) / 2) ==
                                    text.charAt((i - L[i] - 1) / 2)))) {
                L[i]++;
            }

            if (L[i] > maxLPSLength) // Track maxLPSLength
            {
                maxLPSLength = L[i];
                maxLPSCenterPosition = i;
            }

            // If palindrome centered at currentRightPosition i
            // expand beyond centerRightPosition R,
            // adjust centerPosition C based on expanded palindrome.
            if (i + L[i] > R) {
                C = i;
                R = i + L[i];
            }

            // Uncomment it to print LPS Length array
            // printf("%d ", L[i]);
        }

        start = (maxLPSCenterPosition - maxLPSLength) / 2;
        end = start + maxLPSLength - 1;
        for (i = start; i <= end; i++)
            System.out.print(text.charAt(i));
        System.out.println();
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int count = paragraphList.size() - 1;
        for (int i = 0; i < paragraphList.size(); i++) {
            if (i < count) {
                stringBuilder.append(paragraphList.get(i)).append("\n");
            } else stringBuilder.append(paragraphList.get(i));
        }
        return stringBuilder.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;

        Text text = (Text) o;

        return getParagraphList() != null ? getParagraphList().equals(text.getParagraphList()) : text.getParagraphList() == null;
    }

    @Override
    public int hashCode() {
        return getParagraphList() != null ? getParagraphList().hashCode() : 0;
    }
}

