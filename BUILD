
load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_import", "kt_jvm_binary")

#
# Import Arrow
#

kt_jvm_import(
    name = "arrow_lib",
    jars = [
        "@io_arrow_kt_arrow_core//jar:file",
        "@io_arrow_kt_arrow_syntax//jar:file",
        "@io_arrow_kt_arrow_typeclasses//jar:file",
        "@io_arrow_kt_arrow_data//jar:file",
        "@io_arrow_kt_arrow_instances_core//jar:file",
        "@io_arrow_kt_arrow_instances_data//jar:file",
        "@io_arrow_kt_arrow_annotations//jar:file",
    ],
)

#
# Main Works Program
#

kt_jvm_binary(
    name = "MainWorks",
    srcs = ["MainWorks.kt"],
    main_class = "com.bakpax.bazel_arrow_kt.MainWorksKt",
    deps = [
        ":arrow_lib",
    ],
)

#
# Main Fails Program
#

kt_jvm_binary(
    name = "MainFails",
    srcs = ["MainFails.kt"],
    main_class = "com.bakpax.bazel_arrow_kt.MainFailsKt",
    deps = [
        ":arrow_lib",
    ],
)
