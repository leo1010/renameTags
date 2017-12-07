
Simple Scala script to rename tags in `INFO` field in a given VCF file. 
Metadata in preamble of VCF file is updated accordingly.

Create a jar file with
```
sbt package
```

Rename `AC` and `AF` tags on a bgzip compressed VCF file for instance  with

```
zcat file.vcf.gz \
| scala ./target/scala-2.11/renametags_2.11-1.0-SNAPSHOT.jar AC:AC_DATASET AF:AF_DATASET \
| bgzip -c > file_AC_AF_renamed.vcf.gz
```

