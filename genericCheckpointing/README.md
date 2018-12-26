
#### Note: build.xml is present in genericCheckpointing/src folder.
-
## Instruction to clean:

####Command: ant -buildfile genericCheckpointing/src/build.xml clean

## Instruction to compile:

####Command: ant -buildfile genericCheckpointing/src/build.xml all

## Instruction to run:

####Command: ant -buildfile genericCheckpointing/src/build.xml run -Darg0=<mode> -Darg1=<num_objects> -Darg2=<file_path>

MODE = "serdeser" or "deser"
==> use "serdeser" first to generate an output file.
==> "deser" can be used to deserialize an existing output file