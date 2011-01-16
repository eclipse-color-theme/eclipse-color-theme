* Make colour theme keys non-redundant, consistent and understandeable.
  * Change methodDeclarationName to methodDeclaration.
  * Use "invocation" and "declaration" consistently.
  * Figure out what currentIP and secondaryIP do and remove if possible.
* Define more default color entry mappings, e.g.:
  * staticFinalField = staticField
  * staticField = field
  * field = foreground
  * interface = class
  * staticMethodInvocation = foreground 
* Make it possible to import/export theme files (check definition version on
  import).
* Add more themes, at least the following:
  * Wombat
* Add support for more editors, e.g.:
  * Clojure
  * PDE (plugin.xml etc.)
  * Ant
  * PHP
  * Python
* Add a colour editor like the one in Textmate.
* Re-apply the selected theme when the plugin is updated (or on each startup).
* Make it possible for themes to define text decorations (bold, italic etc.).
