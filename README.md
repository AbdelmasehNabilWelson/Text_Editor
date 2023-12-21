# Text_Editor
Text Editor is a simple app used to work with texts. Provides functionalities like Flesch index, generating Markov text, edit distance, autocomplete, and spell checking.

# Current Implemented functionality
* Flesch index: is a measure of how easy a piece of text is to read.
* Markov text generator: generates new text based on the statistical patterns found in a given set of input text
  * The idea is that we train the generator that results in a list of lists such that each word is linked with all words that come after it in the given text.
  * if we train the generator on the string ("hi there hi Leo") MarkovTextGenerator produces:
     <div style="border: 1px solid #aaa; padding: 10px; margin: 10px; background-color: #f5f5f5;">
     <p>there->Leo-></p>
     <p>there: hi-></p>
     <p>Leo: hi-></p>
     
     </div>


* Spell checking and AutoComplete but currently works for small letters(I will improve this later).
  * I have implemented the auto complete function using the Trie data structure. see the AutoCompleteDictionaryTrie in the spelling package.
* Edit Distance: is A Word Paths game where that finds a path from one word to another with the restriction that we can only make one change at a time (letter permutation, letter insertion, letter deletion) and that whatever change we make, has to result in a real word.


[App demo video](https://www.youtube.com/watch?v=uvIuEG9BfT0&t=25s)





https://github.com/AbdelmasehNabilWelson/Text_Editor/assets/110543597/17bdde2f-6e40-4cb9-ac9b-693a5d124d24






## Project Idea
This project is considered part of the course [Data Structures and Performance](https://www.coursera.org/learndata-structures-optimizing-performancespecialization=object-oriented-programming) provided by US sanDiego university on Coursera platform.

## Notes
* I have Implemented the backend part of the project
