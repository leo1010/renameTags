
Simple Scala script to rename tags in `INFO` field in a given VCF file. 
Metadata in preamble of VCF file is updated accordingly.

Create a fat jar file with
```
sbt assembly
```

Rename `AC` and `AF` tags on a bgzip compressed VCF file for instance  with

```
zcat file.vcf.gz \
| java -jar ./target/scala-2.11/renameTags-assembly-1.0-SNAPSHOT.jar AC:AC_DATASET AF:AF_DATASET \
| bgzip -c > file_AC_AF_renamed.vcf.gz
```
