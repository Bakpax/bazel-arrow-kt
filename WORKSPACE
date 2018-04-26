#
# Load rules_kotlin
#

kotlin_release_version="1.2.30"
rules_kotlin_version = "67f4a6050584730ebae7f8a40435a209f8e0b48e"

http_archive(
    name = "io_bazel_rules_kotlin",
    urls = ["https://github.com/bazelbuild/rules_kotlin/archive/%s.zip" % rules_kotlin_version],
    type = "zip",
    strip_prefix = "rules_kotlin-%s" % rules_kotlin_version
)

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")
kotlin_repositories(kotlin_release_version=kotlin_release_version)
kt_register_toolchains()

#
# Load Arrow
#

maven_jar(
    name = "io_arrow_kt_arrow_core",
    artifact = "io.arrow-kt:arrow-core:jar:0.7.1",
    sha1 = "6258e5f2afd375ef6fd12161a590d6fcc3549361",
)

maven_jar(
    name = "io_arrow_kt_arrow_syntax",
    artifact = "io.arrow-kt:arrow-syntax:jar:0.7.1",
    sha1 = "4be4c37b17d04e4092475e2c4acb918bce982e46",
)

maven_jar(
    name = "io_arrow_kt_arrow_typeclasses",
    artifact = "io.arrow-kt:arrow-typeclasses:jar:0.7.1",
    sha1 = "69348da05051936b50e6dfbe530c59886803144f",
)

maven_jar(
    name = "io_arrow_kt_arrow_data",
    artifact = "io.arrow-kt:arrow-data:jar:0.7.1",
    sha1 = "d7f1f04d7a65c2a4f6a52c9d525e3a6cee1ef902",
)

maven_jar(
    name = "io_arrow_kt_arrow_instances_core",
    artifact = "io.arrow-kt:arrow-instances-core:jar:0.7.1",
    sha1 = "3c144afca856ed07626bef3d9b226478ec8e9689",
)

maven_jar(
    name = "io_arrow_kt_arrow_instances_data",
    artifact = "io.arrow-kt:arrow-instances-data:jar:0.7.1",
    sha1 = "8bb4b6ff89e81fb59b090c11fae1968e3cd8f46d",
)

maven_jar(
    name = "io_arrow_kt_arrow_annotations",
    artifact = "io.arrow-kt:arrow-annotations:jar:0.7.1",
    sha1 = "391929cd47d022b989b0a80e6d4395e0807191f0",
)
