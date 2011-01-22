0.5
===
* Make colour theme keys non-redundant, consistent and
  understandeable.
  * Change methodDeclarationName to methodDeclaration.
  * Use "invocation" and "declaration" consistently.
* Define more default color entry mappings, e.g.:
  * staticFinalField = staticField
  * staticField = field
  * field = foreground
  * interface = class
  * staticMethodInvocation = foreground 

1.0
===
* Add theme file import.
* Add at least one more theme (e.g. Wombat or Sunburst)
* Make it possible for themes to define text decorations (bold,
  italic, underlined).
* Add support for the most common editors:
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
* Add support for more editors, e.g.:
  * Python
  * Clojure
* Support multiple versions of each editor plugin instead of just the
  most current one.
* Theme more than just editors, e.g.:
  * Console
  * Project Explorer
  * Outline
  * ...
