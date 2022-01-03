package net.mm2d.orientation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import net.mm2d.orientation.control.Orientation
import net.mm2d.orientation.settings.IconShape
import net.mm2d.orientation.settings.PreferenceRepository

class DetailedSettingsFragmentViewModel : ViewModel() {
    private val orientationPreferenceRepository =
        PreferenceRepository.get().orientationPreferenceRepository
    private val orientationPreferenceFlow =
        PreferenceRepository.get().orientationPreferenceFlow
    private val controlPreferenceRepository =
        PreferenceRepository.get().controlPreferenceRepository
    private val designPreferenceRepository =
        PreferenceRepository.get().designPreferenceRepository
    private val menuPreferenceRepository =
        PreferenceRepository.get().menuPreferenceRepository

    val menu = menuPreferenceRepository.flow
        .asLiveData()
    val sample = combine(
        orientationPreferenceFlow,
        designPreferenceRepository.flow,
        ::Pair
    ).asLiveData()
    val orientation = orientationPreferenceRepository.flow.asLiveData()
    val control = controlPreferenceRepository.flow.asLiveData()
    val design = designPreferenceRepository.flow.asLiveData()

    fun updateOrientation(orientation: Orientation) {
        viewModelScope.launch {
            orientationPreferenceRepository.updateOrientationManually(orientation)
        }
    }

    fun updateNotifySecret(secret: Boolean) {
        viewModelScope.launch {
            controlPreferenceRepository.updateNotifySecret(secret)
        }
    }

    fun updateUseBlankIcon(use: Boolean) {
        viewModelScope.launch {
            controlPreferenceRepository.updateUseBlankIcon(use)
        }
    }

    fun updateForeground(color: Int) {
        viewModelScope.launch {
            designPreferenceRepository.updateForeground(color)
        }
    }

    fun updateBackground(color: Int) {
        viewModelScope.launch {
            designPreferenceRepository.updateBackground(color)
        }
    }

    fun updateForegroundSelected(color: Int) {
        viewModelScope.launch {
            designPreferenceRepository.updateForegroundSelected(color)
        }
    }

    fun updateBackgroundSelected(color: Int) {
        viewModelScope.launch {
            designPreferenceRepository.updateBackgroundSelected(color)
        }
    }

    fun updateBase(color: Int) {
        viewModelScope.launch {
            designPreferenceRepository.updateBase(color)
        }
    }

    fun resetTheme() {
        viewModelScope.launch {
            designPreferenceRepository.resetTheme()
        }
    }

    fun updateIconize(iconize: Boolean) {
        viewModelScope.launch {
            designPreferenceRepository.updateIconize(iconize)
        }
    }

    fun updateShape(shape: IconShape) {
        viewModelScope.launch {
            designPreferenceRepository.updateShape(shape)
        }
    }

    fun updateShowSettings(show: Boolean) {
        viewModelScope.launch {
            designPreferenceRepository.updateShowSettings(show)
        }
    }

    fun updateOrientations(orientations: List<Orientation>) {
        viewModelScope.launch {
            designPreferenceRepository.updateOrientations(orientations)
        }
    }

    fun updateWarnSystemRotate(warn: Boolean) {
        viewModelScope.launch {
            menuPreferenceRepository.updateWarnSystemRotate(warn)
        }
    }

    fun updateOrientationWhenPowerIsConnected(orientation: Orientation) {
        viewModelScope.launch {
            orientationPreferenceRepository.updateOrientationWhenPowerIsConnected(orientation)
        }
    }
}