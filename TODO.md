1.0
===
* Add support for the most common editors:
  * JAR Manifest
  * PDE (plugin.xml etc.)
  * ...
* Re-apply the selected theme when the plugin is updated (or on each
  startup).
* Re-apply selected theme on preferences import.
* Only apply preferences for existing plugins. Ask for re-apply when
  plugins are installed.
* Add a preview for the selected theme to the preferences page.
* Make it possible to delete imported themes.
* Don't re-apply the theme when pressing *OK* if it has already been
  applied by pressing *Apply*.

Ideas
=====
* Add mapping file import support.
* Add support for more editors, e.g.
  * Scala
  * PHPEclipse
  * Clojure
  * Ruby/JRuby
  * ActionScript/MXML
* Support multiple versions of each editor plugin instead of just the
  most current one.
* Theme more than just editors, e.g.:
  * Console
  * Project Explorer
  * Outline
  * ...
