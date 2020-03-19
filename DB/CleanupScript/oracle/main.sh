#!/bin/sh
sqlplus feelview/feelview << EOF

@./truncateTab.sql

exit;
EOF