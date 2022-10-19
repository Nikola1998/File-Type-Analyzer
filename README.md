# File-Type-Analyzer
This is one of the projects from JetBrains Academy in which I've learned a lot about IO, multi-threading, streaming large files, how to detect each file type, also some fast algorithms for searching for certain substrings and much more. Here's the link to the task on their website: https://hyperskill.org/projects/64?track=17

The program should be run with 2 command line arguments:
 1. should be the directory where the program is supposed to check for file types.
 2. should be the 'patterns.db' file in which are located the patterns(substrings) and their names(names of the file type)
 
 
Example of what the 'patterns.db' file might contain:
1;"%PDF-";"PDF document"
2;"pmview";"PCP pmview config"
4;"PK";"Zip archive"
5;"vnd.oasis.opendocument.presentation";"OpenDocument presentation"
6;"W.o.r.d";"MS Office Word 2003"
6;"P.o.w.e.r.P.o.i";"MS Office PowerPoint 2003"
7;"word/_rels";"MS Office Word 2007+"
7;"ppt/_rels";"MS Office PowerPoint 2007+"
7;"xl/_rels";"MS Office Excel 2007+"
8;"-----BEGIN\ CERTIFICATE-----";"PEM certificate"
9;"ftypjp2";"ISO Media JPEG 2000"
9;"ftypiso2";"ISO Media MP4 Base Media v2"


Every pattern is composed of 3 different parts:
 1. is the priority number
 2. is the substring to be searched for
 3. is the file type name
