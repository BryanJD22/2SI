;
; Message file for SAPGUI.
;
;  Copyright
;    SAP AG, www.sap.com
;    Last Update : 2022/04/06
;

Const
  ; verbosity dialog extra items to adapt verbosity of SAPGUI-specific items
  ; the string segment after ':' and before "|" is displayed to present alternatives to the user
  ; e.g. "SAPGUI Verbosity Level", "SAPGUI Steploop Mode", ...
  ; the other part is the name of a function (and must not be translated)
  SapGuiVerbosityItems="|ToggleSapGuiAccVerbosity:SAPGUI verbosit�|ToggleSapGuiSteploopMode:SAPGUI mode de step loop "
  ;For column review - KK (discontinued)
  ; jvToggleColumnReview="|ToggleColumnReviewVerbosity:s�lectionnez colonne de contr�le courante"
messages

; Give version information
@msgSapGuiAppName
Sapfront screen reader extensions (extensions de lecture d'�cran)
@@

; Status message saving application settings
@msgAppSettingsSaved
param�tres d'application sauvegard�s
@@
@msgAppSettingsNotSaved
n'a pas pu sauvegarder des param�tres d'application
@@

;
; Messages concerning the verbosity levels and modes:
;
; switch the annoucement of an item "off" in the verbosity dialog
@msgSapGuiModeOff
desactiv�
@@
; switch the annoucement of an item "on" in the verbosity dialog
@msgSapGuiModeOn
activ�
@@
; set verbosity level for an item to "low"
@msgSapGuiAccVerbosityLow
r�duite
@@
; set verbosity level for an item to "high"
@msgSapGuiAccVerbosityHigh
d�taill�e
@@
@msgSapGuiScriptsNotRunning
Attention. Les extensions de lecture d'�cran n'est pas soutenir par cette session utilisateur.
@@
@msgSapGuiSessionBusy
Attention. Session n'est pas pr�t pour la saisie. Veuillez patienter svp.
@@

;
; TextFields/Edits
; Generally, the standard JAWS presentation is used
;
; CTextFields - text boxes with F4 help button are announced as "F4 edit"
@msgGuiCTextField
�dition du F4 avec aide � la saisie
@@

;
; with F4 help;
@msgGuiHasF4Help
F4 aide � la saisie
@@

;
; Labels
;
; Label / static text - no announcement is made for regular labels
@msgGuiLabel

@@
@msgBrlLabel
Txt
@@
@msgBrlSeparator
-
@@
@msgLabelHasType
label est
@@

;
; Icons
;
@msgGuiIcon
Ic�ne
@@
@msgBrlIcon
Ico
@@

;
; Hotspot and link modifier messages, used in combination with annoncement of  control type
;
@msgIsHotspot
Hotspot
@@
@msgHasHotspot
avec hotspot
@@
@msgHotspotTutor
Pour l�activer, f2
@@
@msgIsLink
Lien
@@
@msgHasLink
avec lien
@@
@msgBrlIsHotspot
*
@@
@msgBrlHasHotspot
*
@@

;
; Button
;
; Additional speech annoucement for the special "table settings" button
@msgGuiButtonTableSettings
Bouton des param�tres du table
@@

; OKCodeField (the one and only transaction code field)
@msgGuiOkCodeField
Zone de commande
@@
@msgBrlGuiOkCodeField
Cmd
@@

;
; announcements for system and application toolbar
;
@msgSystemToolbar
Barre de fonctions syst�me
@@
@msgApplicationToolbar
Barre d'outils d'application
@@
@msgEndOfToolbar
quitter barre d'outils
@@
@msgBrlApplicationToolbar
bdoa
@@
@msgBrlSystemToolbar
bdos
@@

; footer toolbar area in Belize themed systems
@msgFooter
bas de page
@@
@msgEndOfFooter
quitter bas de page
@@
@msgBrlFooter
bdp
@@

;
; define the text of the system toolbar buttons
;
@msgBtnTextSave
sauvegarder (Ctrl+S)
@@
@msgBtnTextBack
retour (F3)
@@
@msgBtnTextExit
terminer (Maj+F3)
@@
@msgBtnTextCancel
interrompre (F12)
@@
@msgBtnTextPrint
imprimer... (Ctrl+P)
@@
@msgBtnTextFind
rechercher(Ctrl+F)
@@
@msgBtnTextFindNext
continuer recherche(Ctrl+G)
@@
@msgBtnTextFirstPage
premi�re page (Ctrl+Ecr. pr�c.)
@@
@msgBtnTextPreviousPage
page pr�c�dente (Ecr. pr�c.)
@@
@msgBtnTextNextPage
page suivante (Ecr. suiv.)
@@
@msgBtnTextLastPage
derni�re page (Ctrl+Ecr. suiv.)
@@
@msgBtnTextCreateSession
cr�er un nouveau mode
@@
@msgBtnTextGenerateShortcut
cr�e un raccourci
@@
@msgBtnTextStartAccCheck
lancer FACTS
@@
@msgBtnTextHelp
aide (F1)
@@
@msgBtnTextOkCode
afficher (Entr�e)
@@
@msgBtnCommandField
fermer ou ouvrir zone de commande
@@
@msgBtnLocalLayout
ajuster mise en form locale
@@

; GuiCombobox
;
; GuiComboboxes are announced as "dropdown listbox"
@msgGuiCombobox
Liste d�roulante
@@
; Message denotes the current position within the list box - %n are placeholders for numeric values
; %1 = current item no - %2 = total number of items
; e.g. "4 of 10" means that currently the 4th item is shown and the list box
; contains 10 items altogether
@msgGuiComboboxPosition
%1 sur %2
@@
; The number of items within the list box
@msgGuiComboboxCount
%1 �l�ments
@@
@msgGuiComboboxSingleEntry
%1 �l�ment
@@

;
; Radio buttons
;
; Indicates that the current radio button item is activated
@msgGuiRadioButtonSelected
coch�
@@
; Indicates that the current radio button item is not activated
@msgGuiRadioButtonNotSelected
non coch�
@@

; Message denotes the current position within the radio button group
; %1 = current item no - %2 = total number of items in group
@msgGuiRadioButtonPosition
%1 sur %2
@@

;
; Picture control
;
@msgGuiPicture
Graphique
@@
;
; Editor control
;
@msgGuiTextEdit
�dition multiligne
@@

;
; Tabstrip
;
; Indicates that the currently focused tab is activated
@msgGuiTabSelected
s�lectionn�
@@
; Indicates that the currently focused tab is not activated
@msgGuiTabNotSelected
non s�lectionn�
@@

;
; TableControl
;
; Announced when entering a table
@msgTableControl
dans un tableau
@@
; Denotes the current row position within the table
; %1 = current row no - %2 = total number of rows
@msgTablePositionRows
Enregistrement ligne %1 sur %2
@@
; Denotes the current row position within the table
; %1 = current item no - %2 = total number of visible items
@msgTablePositionVisibleRows
Ligne visible %1 sur %2
@@
; Number of total rows and total visible rows in the table
@msgTableVisibleTotalRows
%1 enregistrements et %2 lignes visibles
@@
; Denotes the current column position within the table
; %1 = current column no - %2 = total number of columns
@msgTablePositionCols
Colonne %1 sur %2
@@
; Indicates that row is selectable
@msgTableRowSelectable 
s�lectionnable
@@
; %1=table name - %2=row - %3=column
@msgBrlTableInfo
%1 l%2c%3
@@
; Message given if a table command is invoked outside a table
@msgNotInTable
Vous n��tes pas dans un tableau
@@
; Annouced when navigating to the last visible row of the table
@msgTableLastVisibleRow
fin de ligne visible
@@
; Annouced when navigating to the last visible cell of the table
@msgTableLastVisibleCell
fin de ligne visible
@@
; Annouced when inserting a row to a table
@msgTableRowInserted
ligne ins�r�
@@
; Annouced when deleting a row of a table
@msgTableRowDeleted
ligne supprim�
@@
@msgEndOfTable
fin du tableau
@@
@msgEmptyTable
tableau est vide
@@

;
; Steploop
;
; Announced when entering a steploop
@msgStepLoop
step loop
@@
; Number of total rows and total columns in the steploop
@msgStepLoopRowsTotal
%1 lignes
@@
; Annouced when navigating to the last row of the steploop
@msgStepLoopLastRow
fin de ligne du step loop
@@
; Annouced when navigating to the last cell of the steploop
@msgStepLoopLastCell
fin de cellules du step loop
@@

;
; Splitter shell
;
@msgGuiSplitter
S�parateur
@@
@msgGuiSplitterVertical
verticale
@@
@msgGuiSplitterHorizontal
horizontale
@@
@msgGuiSplitterCombined
combin�
@@
; Position (coordinates) of objects within splitter
@msgGuiSplitterVerticalPos
� gauche %1 %2% � droite %3 %4%
@@
@msgGuiSplitterHorizontalPos
au-dessus %1 %2% au-dessous %3 %4%
@@

; Braille message for the splitter
@msgBrlGuiSplitterVerticalPos
(gch %1 %2% / dte %3 %4%)
@@
@msgBrlGuiSplitterHorizontalPos
(au-dessus %1 %2% / au-dessous %3 %4%)
@@
;
; Docking shell
;
@msgGuiDockShellVertical
S�parateur verticale
@@
@msgGuiDockShellHorizontal
horizontaler trenner
S�parateur horizontale
@@
@msgGuiDockShellVerticalPos
largeur %1 %2%
@@
@msgGuiDockShellHorizontalPos
hauteur %1 %2%
@@
@msgBrlGuiDockShellVerticalPos
l %1 %2%
@@
@msgBrlGuiDockShellHorizontalPos
h %1 %2%
@@

;
; OTF preview
;
@msgOTFPreviewType
pr�visualisation
@@
@msgBrlOTFPreviewType
pv
@@

;
; APO Grid
;
@msgGuiCtrlApoGrid
apo grid
@@
@msgGuiCtrlApoGridLastRow
fin de lign du apo grid
letzte Zeile des apo grid
@@
@msgGuiCtrlApoGridLastCell
fin de cellules du apo grid
@@

;
; GuiBox: Groups of controls are announced as "group" along with it's title when the focus comes to the group
;         A group contained within another group is being announced as "subgroup <subgroup-title> of group <group-title>"
;
@msgBeginOfGroup
bo�te de groupe
@@
@msgSubgroup
sous-groupe %1 de groupe %2
@@
@msgEndOfGroup
fin de groupe
@@

;
; ALV
;
; ALV name - announced when entering the ALV
@msgALV
grid view
@@
; Denotes the current column position within the ALV
; %1 = current column no - %2 = total number of columns
@msgALVPositionColumns
colonne %1 sur %2
@@
; Denotes the current row position within the ALV
; %1 = current row no - %2 = total number of rows
@msgALVPositionRows
enregistrement ligne %1 sur %2
@@
; Annouced when navigating to the last visible row
@msgALVLastVisibleRow
fin de ligne
@@
; Annouced when navigating to the last visible cell
@msgALVLastVisibleCell
fin de cellules
@@

; messages given for certain ALV column properties
@msgALVIsColumnKey
cl�
@@
@msgALVIsColumnFiltered
filtr�
@@
@msgALVIsColumnSorted
assorti
@@
@msgALVIsColumnSortedAsc
ascendant 
@@
@msgALVIsColumnSortedDesc
descendant
@@
@msgALVColumnTypeTotal
contenir des totals
@@
@msgALVColumnTypeSubtotal
contenir des sous-totals
@@
@msgALVColumnOperationTypeMean
inclure la moyenne
@@
@msgALVColumnOperationTypeMinimum
inclure le minimum
@@
@msgALVColumnOperationTypeMaximum
inclure le maximum
@@

; Denotes the ALV cell type "symbol"
@msgALVSymbol
symbole
@@

; annoncement of header
@msgALVHeader
barre d'en-t�te
@@

; Braille messages for ALV
@msgBrlALVTextField
�d
@@
@msgBrlALVIsColumnKey
c
@@
@msgBrlALVIsColumnFiltered
f
@@
@msgBrlALVIsColumnSortedAsc
asc
@@
@msgBrlALVIsColumnSortedDesc
desc
@@
@msgBrlALVSymbol
sym
@@
@msgBrlALVExpander
exp
@@
@msgBrlALVHeader
TLgn
@@
@msgBrlALVHeaderInfo
s%1
@@
@msgBrlALVColumnTypeTotal
total
@@
@msgBrlALVColumnTypeSubtotal
sous-total
@@
@msgBrlALVColumnOperationTypeMean
moy
@@
@msgBrlALVColumnOperationTypeMinimum
min
@@
@msgBrlALVColumnOperationTypeMaximum
max
@@

;
; Trees
;

; Type of trees:
@msgTreeABAPListTree
Arborescence
@@
@msgTreeSimple
Arborescence simple
@@
@msgTreeList
Arborescence list
@@
@msgTreeColumn
Arborescence colonne
@@

; message for single tree entry
@msgTreeEntry
�l�ment
@@
; message for multiple tree entries
@msgTreeEntries
�l�ments
@@

; current level within the tree
@msgTreeLevel
niveau
@@
; number of items contained within this level (used for trees or tabs)
@msgItemPosition
%1 sur %2
@@
; to announce the name of the column
@msgTreeItemColumn
colonne
@@

; types of tree items
@msgTreeTypeHierarchy
niveau
@@
@msgTreeTypeImage
graphique
@@
@msgTreeTypeText
texte
@@

; number of nodes which are selected (marked)
@msgTreeSelectedNodeCount
%1 noeuds s�lectionn�
@@
; name of single tree node
@msgTreeNode
noeud
@@
; name of multiple tree nodes
@msgTreeNodes
noeuds
@@
; Indicates that the node is marked
@msgTreeNodeMarked
s�lectionn�
@@

;Used for the command to read entire node
@msgTreeNotValid
fonction non disponsible
@@
@msgTreeNodeSelection
avec s�lection simple
@@
@msgTreeSingleNodeTutor
Pour obtenir plus d'information sur ce noeud, appuyez sur INSERT + MAJ + FL�CHE HAUT.
@@ 
; Braille messages for trees
@msgBrlTreeSimple
Arb
@@
@msgBrlTreeList	
ArbLst
@@
@msgBrlTreeColumn
ArbCol
@@
@msgBrlTreeLevel
Niv
@@
@msgBrlTVImage
Img
@@
@msgBrlTVHierarchy
hrc
@@
@msgBrlTVNodeClosed
+
@@
@msgBrlTreeTypeText
txt
@@

; Calendar format strings
; "week number" announcement
@msgCalendarWeekNumber
semaine
@@
; announcing/presenting different elements of calendar
@msgCalendarButton
ouvrir/fermer navigateur de dates
@@
@msgCalendarNavigator
navigateur de calendrier
@@
@msgBrlCalendarNavigator
nav
@@
@msgCalendarToday
aujourd'hui
@@

;
; Control and item states
;
; indicates a read-only item/control (eg. read-only edits)
@msgStateReadOnly
en lecture seule
@@
@msgStateHighlighted
surlign�
@@
@msgStateRequired
requis
@@
@msgStateInvalid
non valide
@@

; used to announce a color (%1 = number of color)
@msgStateColorNumber
Couleur %1
@@
; Braille state messages
@msgBrlStateReadOnly
lec
@@
@msgBrlStateHighlighted
surl
@@
@msgBrlStateRequired
rq
@@

; to indicate that items are selected (marked) for further processing
@msgItemsSelected
s�lectionn�
@@
@msgItemsNotSelected
pas s�lectionn�
@@

; selection modes (in ALV GridView)
@msgSelModeSingleRow
mode de s�lection ligne
@@
@msgSelModeMultipleRows
mode de s�lection multiligne
@@
@msgSelModeRowsAndColumns
mode de s�lection lignes et colonnes
@@
@msgSelModeFree
mode de s�lection libre
@@

;
; Status bar
;
@msgStatusBarMessage
message statut
@@
@msgNoStatusBarMessage
non message statut
@@
@msgStatusBarMessageSuccess
message status de succ�s
@@
@msgStatusBarMessageError
message status d'erreur
@@
@msgStatusBarMessageWarning
message status d'alerte
@@
@msgStatusBarMessageAbort
message status annul�e
@@
@msgStatusBarMessageInformation
message status d'information
@@
@msgStatusBarDetails
message status detaill� disponsible
@@

;
; ABAP Lists
;
@msgLstGroupHeader
ligne d'en-t�te du groupe
@@
@msgLstSubGroupHeader
ligne d'en-t�te du sous-groupe
@@
@msgLstSubGroupLABEL
titre du sous-groupe
@@
@msgLstHeader
ligne d'en-t�te
@@
@msgLstGroupLabel
titre du groupe
@@
@msgLstFreeText
texte libre
@@
; the following is used in the form: "<current-item-number> of <total-number-of-items>"
@msgLstOf
sur
@@
; single "row" in ABAP-list structures
@msgLstRow
ligne
@@
; multiple "rows" in ABAP-list structures
@msgLstRows
lignes
@@
; single "column" in ABAP-list structures
@msgLstColumn
colonne
@@
; multiple "column" in ABAP-list structures
@msgLstColumns
colonnes
@@
; single "group" in ABAP-list structures
@msgLstGroup
groupe
@@
; multiple "groups" in ABAP-list structures
@msgLstGroups
groupes
@@
; single "subgroup" in ABAP-list structures
@msgLstSubGroup
sous-groupe
@@
; multiple "subgroups" in ABAP-list structures
@msgLstSubGroups
sous-groupes
@@
; to announce the line number in ABAP-list structures
@msgLine
ligne
@@
; to announce subordinate columns in ABAP-list structures (with super column header)
@msgSubordinateColumns
colonne subordonn�
@@
; to announce super columns in ABAP-list structures
@msgSuperColumn
colonne sup�rieur
@@

; modifiers/properties of list fields
@msgLstFieldModifierNegative
n�gative
@@
@msgLstFieldModifierThreshold
d�passement du seuil
@@
@msgLstColumnModifierKey
cl�
@@

; container title in ABAP-list structures
@msgLstContainerTitle
titre
@@
; container list in ABAP-list structures
@msgLstContainerList
tiste
@@

; to specify the contents of the container (e.g. "list with <number-of-items> checkboxes")
@msgLstWith 
avec
@@

; table(s), tree(s), textboxe(s), ... in ABAP-list structures
@msgLstTable
Tableau
@@
@msgLstTables
Tableaus
@@
@msgLstTree
Arborescence
@@
@msgLstTrees
Arborescences
@@
@msgLstTextbox
Zone de texte
@@
@msgLstTextboxes
Zones
@@
@msgLstCheckboxes
Cases � cocher
@@
@msgLstEditfields
�ditions
@@
@msgLstCheckboxesAndEditfields
Cases � cocher et �ditions
@@

; to annouce a number of items in ABAP-list structures, eg. "tree number 5"
@msgLstNumber
num�ro
@@

; to announce number of hierarchical levels in ABAP-list structures
@msgLst2HierarchyLevels
avec %1 groupes
@@
@msgLst3HierarchyLevels
avec %1 groupes et sous-groupes
@@
; announce ALV like in ABAP-list structures
@msgLstALVlikeHierarchy
avec groupes
@@

;
; Braille symbols for ABAP lists and tables
;
@msgBrlLstTable
LstTbl
@@
@msgBrlLstTree
LstArb
@@
@msgBrlLstGroup
LstGrp
@@
@msgBrlLstSubgroup
LstSous
@@
@msgBrlLstContainerList
Lst
@@
@msgBrlLstFieldModifierThreshold
^
@@
@msgBrlLstFieldModifierNegative
-
@@
@msgBrlLstNormalHeaderType
TCol
@@
@msgBrlLstSuperColumnHeaderType
TSousCol
@@
@msgBrlLstGroupHeaderType
TGrpCol
@@

@msgBrlLstTablePosInfo
l%1c%2
@@
@msgBrlLstNormalHeaderInfo
c%1
@@
@msgBrlLstGroupInfo
grp%1
@@
@msgBrlLstSubGroupInfo
sousgrp%1
@@

@msgLstRowSelection
s�lectionner ligne
@@

;
; to annouce inserted line (in ABAP-lists and ALV)
;
@msgInsertedLine
ins�r�
@@
; this is the inserted line type: text, total or sub total (summation sub summation)
@msgInsertedLineTypeText
texte
@@
@msgInsertedLineTypeSummation
totalisation
@@
@msgInsertedLineTypeSubSummation
sous-totalisation
@@

; Braille for line insertion type
@msgBrInsertedLineTypeSummation
--total--
@@

;
; Annoucements for session info
;
@msgSessionInfoSystem
Syst�me
@@
@msgSessionInfoClient
Mandant
@@
@msgSessionInfoUser
Utilisateur
@@
@msgSessionInfoProgram
Programme
@@
@msgSessionInfoTransaction
Transaction
@@
@msgSessionInfoInterpretationTime
D�lai d'interpretation
@@
@msgSessionInfoRoundTrips
Temps de r�ponse
@@
@msgSessionInfoFlushes
Flushs
@@

;
; Annoucements for inplace controls
;
@msgInternetExplorer
Browser utilis�
@@
@msgTutorInternetExplorer
Les param�tres Internet Explorer sont utilis�s
@@
@msgEdge
Browser utilis�
@@
@msgTutorEdge
Les param�tres Edge sont utilis�s
@@
@msgWinword
Conteneur Word
@@
@msgTutorWinword
Les param�tres Microsoft Word sont utilis�s
@@
@msgExcel
Conteneur Excel
@@
@msgTutorExcel
Les param�tres Microsoft Excel configuration sont utilis�s
@@
@msgPowerPoint
Conteneur PowerPoint
@@
@msgTutorPowerPoint
Les param�tres Microsoft Power Point sont utilis�s
@@
@msgWordPerfect
Conteneur Word Perfect
@@
@msgTutorWordPerfect
Les param�tres Word Perfect sont utilis�s
@@
@msgAdobeAcrobat
Conteneur PDF
@@
@msgTutorAdobeAcrobat
Les param�tres Adobe Acrobat sont utilis�s
@@
@msgProject
Conteneur Project
@@
@msgTutorProject
Les param�tres Microsoft Project sont utilis�s
@@
@msgOfficeContainerIsEmpty
Conteneur est vide
@@

;
; Announcement in text editor (meaning of colored lines of text)
;
@msgTextEditorBreakpoint
ligne avec point d'arr�t
@@
@msgTextEditorSelected
ligne selectionn�
@@
@msgTextEditorProtected
ligne prot�g�
@@
@msgTextEditorComment
ligne de commentaire
@@


;
; (new) ABAP editor
@msgGuiAbapEditor
�dition ABAP
@@
@msgTextEditorCollapsedLine
bloc ferm�
@@
@msgTextEditorBlockStartLine
d�but de bloc
@@
@msgTextEditorBlockEndLine
fin de bloc
@@
@msgTextEditorNoBlock
bloc pas trouv�
@@
@msgTextEditorBookmark
signet cr�e
@@
@msgTextEditorNumberedBookmark
signet num�ro %1 cr�e
@@
@msgTextEditorNoBookmark
signet pas trouv�
@@
@msgTextEditorLineNumber
ligne %1 sur %2
@@
@msgTextEditorModified
modifi�e
@@
@msgTextEditorAutoComplete
saisie semi-automatique
@@
@msgTextEditorAutoCompleteToolbar
ALT+%1 pour basculer %2
@@
@msgTextEditorQuickInfoUnavailable
info-bulle non disponsible
@@
@msgTextEditorToolbarUnavailable
Barre de fonctions syst�me non disponsible
@@

;For Column review feature - KK
;
;Announcements for Column Review
;
@msgNoSelection
Pas de colonne de contr�le s�lectionn�e pour le relire
@@
@msgBlankCell
Cellule courante est vide
@@
@msgClearSelection
colonne de contr�le re-initialis�
@@
@msgColumnSelect
s�lectionner
@@
@msgColumnClear
re-initialiser
@@
@msgColumnSet
colonne de contr�le s�lectionn�e
@@
@msgColumnSetError
pas possible de s�lectionner une colonne de contr�le
@@

;
; history listbox of input fields has opened
;
@msgHistoryOpened
Liste d'historique ouverte
@@
@msgHistoryCount
%1 �l�ments
@@
@msgHistorySingleEntry
%1 �l�ment
@@

;
; message for buttons with property emphasized (only in Belize)
;
@msgChangeModeButton
Change modes d'�dition ou d'affichage
@@
;
; messages for view switch control (only in Belize)
;
@msgGuiVHViewSwitchName
Mode d'affichage
@@

;
; some other general messages
;
@msgBlank
vide
@@
@msgNotSelected
non s�lectionn�
@@

endMessages
