package dev.aaa1115910.bv.sponsorblock.entity

data class SponsorBlockSettings(
    val enabled: Boolean,
    val autoSkip: Boolean,
    val showSkipButton: Boolean,
    val showToast: Boolean,
    val categories: Set<String>
)
