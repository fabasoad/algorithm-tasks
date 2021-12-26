#!/bin/bash

# Prepare file.txt with the following content:
# 987-123-4567
# 123 456 7890
# (123) 456-7890
# 0123-456-7891
# (001)-345-0000

# where:
# valid
# invalid
# valid
# invalid
# invalid

# ^\({0,1}[0-9]{3}\){0,1}[-\ ]{0,1}[0-9]{3}-{0,1}[0-9]{4}$

grep -E "(^[0-9]{3}-[0-9]{3}-[0-9]{4}$|^\([0-9]{3,3}\) [0-9]{3}-[0-9]{4}$)" file.txt
