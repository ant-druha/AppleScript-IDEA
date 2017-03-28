# How to AppleScript in IDEA

This plugin, provides support for writing and executing scripts with an [AppleScript](https://developer.apple.com/library/mac/documentation/AppleScript/Conceptual/AppleScriptLangGuide/introduction/ASLR_intro.html) language in IntelliJ-base IDEs.


[![](https://github.com/human87/AppleScript-IDEA/blob/master/img/quick_demo.gif "AppleScript scripting demo")](https://twitter.com/appcode/status/750380127431917568)

## Working with scriptable applications

-	Use predefined [Live Templates](https://www.jetbrains.com/idea/help/live-templates.html):
“tellap”, “useapp” and create your own:

!["tellap" live templete](https://github.com/human87/AppleScript-IDEA/blob/master/img/live_template.png)
![installed applications completion](https://github.com/human87/AppleScript-IDEA/blob/master/img/app_completion.png)

-	Use [Intention Action](https://www.jetbrains.com/idea/help/intention-actions.html) for creating application dictionary if the application was not found:

![add_dictionary.png](https://github.com/human87/AppleScript-IDEA/blob/master/img/add_dictionary.png)


Choose either the application bundle or application dictionary file if the application is not installed but it’s dictionary file is available (xml or sdef extensions):

![choose_dictionary.png](https://github.com/human87/AppleScript-IDEA/blob/master/img/choose_dictionary.png)
The action is also available via File menu (File | Load Dictionary).

For example, you can choose dictionary file to load when working on Windows or Linux. Running scripts will not be possible but intellisense will work:

![browse_doc.png](https://github.com/human87/AppleScript-IDEA/blob/master/img/browse_doc.png)

-	[Run](https://www.jetbrains.com/idea/help/creating-and-editing-run-debug-configurations.html) scripts:

![run.png](https://github.com/human87/AppleScript-IDEA/blob/master/img/run.png)

## Use other IntelliJ IDEA features while working with code: 
-	Basic [Code Completion](https://www.jetbrains.com/idea/help/basic-code-completion-completing-names-and-keywords.html)
-	[Code navigation](https://www.jetbrains.com/idea/help/navigating-to-declaration-or-type-declaration-of-a-symbol.html)
-	[Structure tool window](https://www.jetbrains.com/idea/help/structure-tool-window-file-structure-popup.html)
-	[Find usages](https://www.jetbrains.com/idea/help/finding-usages-in-project.html)
-	[Rename refactoring](https://www.jetbrains.com/idea/help/rename-refactorings.html)
-	[Browsing documentation](https://www.jetbrains.com/idea/help/viewing-inline-documentation.html)
-	[Code reformat](https://www.jetbrains.com/idea/help/reformatting-source-code.html)
-	[Customize Colors and Fonts](https://www.jetbrains.com/idea/help/configuring-colors-and-fonts.html)

![dark_preview.png](https://github.com/human87/AppleScript-IDEA/blob/master/img/dark_preview.png)

### There are still some fixes TODO:
-	parser tuning, including case-insensitivity
-	resolve for some cases with different visibility scopes in scripts
-	auto-formatting of generated dictionary file
- code generate action for common constructs (user handlers, OS interaction scenarios, other statements)
-	your [reports and suggestions](https://github.com/human87/AppleScript-IDEA/issues) ☺

### Download
- [IntelliJ plugins repository](https://plugins.jetbrains.com/plugin/8149)
