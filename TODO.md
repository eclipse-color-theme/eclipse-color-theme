0.5
===
* Make colour theme keys non-redundant, consistent and
  understandeable.
  * Change methodDeclarationName to methodDeclaration.
  * Use "invocation" and "declaration" consistently.
  * Figure out what currentIP and secondaryIP do and remove if
    possible.
* Define more default color entry mappings, e.g.:
  * staticFinalField = staticField
  * staticField = field
  * field = foreground
  * interface = class
  * staticMethodInvocation = foreground
* Re-apply the selected theme when the plugin is updated (or on each
  startup).

1.0
===
* Add theme file import.
* Add at least one more theme (e.g. Wombat or Sunburst)
* Make it possible for themes to define text decorations (bold,
  italic, underlined).
* Add support for the most common editors:
  * Ant
  * PDE (plugin.xml etc.)
  * ...

Ideas
=====
* Add a colour editor like the one in Textmate and theme export.
* Add support for more editors, e.g.:
  * Python
  * Clojure
* Support multiple versions of each editor plugin instead of just the
  most current one.
