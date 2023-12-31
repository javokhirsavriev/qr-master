package uz.javokhir.qr.master.data.database.entity

import database.History
import uz.javokhir.qr.master.data.model.common.QrCustomizeModel
import uz.javokhir.qr.master.data.model.mode.toQrCornerMode
import uz.javokhir.qr.master.data.model.mode.toQrDotMode
import uz.javokhir.qr.master.data.model.mode.toQrPatternMode

data class HistoryEntity(
    val id: String,
    val timestamp: Long,
    val historyType: Long,
    val generateMode: Long,
    val encoded: String,
    val decoded: String,
    val selectedPattern: Long,
    val selectedCorner: Long,
    val selectedDot: Long,
    val patternDotHex: String,
    val patternBackgroundHex: String,
    val frameHex: String,
    val frameDotHex: String,
    val selectedLogo: String,
)

fun History.toEntity(): HistoryEntity {
    return HistoryEntity(
        id = id,
        timestamp = timestamp,
        historyType = history_type,
        generateMode = generate_mode,
        encoded = encode,
        decoded = decode,
        selectedPattern = selected_pattern,
        selectedCorner = selected_corner,
        selectedDot = selected_dot,
        patternDotHex = pattern_dot_hex.ifEmpty { "FF000000" },
        patternBackgroundHex = pattern_background_hex.ifEmpty { "FFFFFFFF" },
        frameHex = frame_hex.ifEmpty { "FF000000" },
        frameDotHex = frame_dot_hex.ifEmpty { "FF000000" },
        selectedLogo = selected_logo,
    )
}

fun HistoryEntity.toModel(): QrCustomizeModel {
    return QrCustomizeModel(
        selectedPattern = selectedPattern.toQrPatternMode(),
        selectedCorner = selectedCorner.toQrCornerMode(),
        selectedDot = selectedDot.toQrDotMode(),
        patternDotHex = patternDotHex,
        patternBackgroundHex = patternBackgroundHex,
        frameHex = frameHex,
        frameDotHex = frameDotHex,
        selectedLogo = selectedLogo,
    )
}