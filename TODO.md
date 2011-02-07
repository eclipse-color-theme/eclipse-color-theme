1.0
===
* Improve the preference page.
  * Add a link to eclipsecolorthemes.org.
  * Add newly imported themes to the list without requiring the user to reopen
    the preferences page.
  * Use a different control for theme selection.
  * Display author and website of each theme.
  * Make it possible to delete imported themes.
* Add mapping file import support.
* Make it possible for themes to define text decorations (bold,
  italic, underlined).
* Add support for the most common editors:
  * JAR Manifest
  * PDE (plugin.xml etc.)
  * ...
* Re-apply the selected theme when the plugin is updated (or on each
  startup).
* Re-apply selected theme on preferences import.
* Only apply preferences for existing plugins. Ask for re-apply when
  plugins are installed.

Ideas
=====
* Don't re-apply the theme when pressing *OK* if it has already been
  applied by pressing *Apply*.
* Add a colour editor like the one in Textmate and theme export.
* Add support for more editors, e.g.
  * Scala
  * PHPEclipse
  * Clojure
  * Ruby/JRuby
  * ActionScript
  * MXML
* Support multiple versions of each editor plugin instead of just the
  most current one.
* Theme more than just editors, e.g.:
  * Console
  * Project Explorer
  * Outline
  * ...
* Define more default color entry mappings, e.g.:
  * staticFinalField = staticField
  * staticField = field
  * field = foreground
  * interface = class
  * staticMethodInvocation = foreground 
