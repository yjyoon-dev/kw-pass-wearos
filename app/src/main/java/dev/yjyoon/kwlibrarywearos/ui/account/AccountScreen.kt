package dev.yjyoon.kwlibrarywearos.ui.account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Badge
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material.icons.outlined.Smartphone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.lazy.AutoCenteringParams
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import com.google.android.horologist.compose.navscaffold.ExperimentalHorologistComposeLayoutApi
import com.google.android.horologist.compose.rotaryinput.rotaryWithScroll
import dev.yjyoon.kwlibrarywearos.R
import dev.yjyoon.kwlibrarywearos.ui.component.KwLibraryChip

@OptIn(ExperimentalHorologistComposeLayoutApi::class)
@Composable
fun AccountScreen(
    onLogin: () -> Unit
) {
    val listState = rememberScalingLazyListState()
    val vignetteState = remember { mutableStateOf(VignettePosition.TopAndBottom) }
    val showVignette = remember { mutableStateOf(true) }
    val focusRequester = remember { FocusRequester() }

    Scaffold(
        positionIndicator = {
            PositionIndicator(
                scalingLazyListState = listState,
                modifier = Modifier
            )
        },
        vignette = {
            if (showVignette.value) {
                Vignette(vignettePosition = vignetteState.value)
            }
        },
        timeText = {
            TimeText()
        }
    ) {
        ScalingLazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .rotaryWithScroll(focusRequester, listState),
            state = listState,
            autoCentering = AutoCenteringParams(0),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            item {
                Text(
                    stringResource(id = R.string.input_account),
                    style = MaterialTheme.typography.title2,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
            }
            item {
                KwLibraryChip(
                    icon = Icons.Outlined.Badge,
                    label = stringResource(id = R.string.id),
                    secondaryLabel = null,
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                KwLibraryChip(
                    icon = Icons.Outlined.Password,
                    label = stringResource(id = R.string.password),
                    secondaryLabel = null,
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                KwLibraryChip(
                    icon = Icons.Outlined.Smartphone,
                    label = stringResource(id = R.string.phone_number),
                    secondaryLabel = null,
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                Spacer(modifier = Modifier.height(12.dp))
            }
            item {
                Button(
                    onClick = onLogin
                ) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = null)
                }
            }
        }
    }
}