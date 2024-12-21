package com.hackerrank.android;

import static com.google.common.truth.Truth.assertThat;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void check_button_text() {
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                Button button = activity.findViewById(R.id.btn_share);
                assertThat(button.getText()).isEqualTo(activity.getResources().getText(R.string.send_btn_text));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check_image() {
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                ImageView imageView = activity.findViewById(R.id.img_screen);
                assertThat(imageView.getDrawable() != null &&
                        imageView.getDrawable().getConstantState()
                                .equals(
                                        activity.getResources().getDrawable(R.drawable.share_image, activity.getTheme()).getConstantState()
                                )
                ).isEqualTo(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check_share_text_from_empty_text() {
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                EditText editText = activity.findViewById(R.id.et_input);
                editText.setText("");
                assertThat(activity.getShareText()).isEqualTo(activity.getResources().getString(R.string.share_empty_text));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check_share_text_from_not_empty_text() {
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                EditText editText = activity.findViewById(R.id.et_input);
                editText.setText("Test Text");
                assertThat(activity.getShareText()).isEqualTo("Test Text");
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check_share_image_uri() {
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                assertThat(activity.getShareImageUri().toString()).isEqualTo("android.resource://com.hackerrank.starter/drawable/share_image");
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check_choose_intent() {
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                Intent checkIntent = activity.createChooserIntent();
                assertThat(checkIntent.getAction()).isEqualTo(Intent.ACTION_CHOOSER);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check_title_choose_intent() {
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                Intent checkIntent = activity.createChooserIntent();
                assertThat(checkIntent.getExtras() != null &&
                        checkIntent.getExtras().get(Intent.EXTRA_TITLE).equals(activity.getResources().getString(R.string.title_chooser_text))
                ).isEqualTo(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check_action_send_intent() {
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                Intent checkIntent = activity.createShareIntent();
                assertThat(checkIntent.getAction() != null &&
                        checkIntent.getAction().equals(Intent.ACTION_SEND)
                ).isEqualTo(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check_type_send_intent() {
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                Intent checkIntent = activity.createShareIntent();
                assertThat(checkIntent.getType() != null && (
                        checkIntent.getType().contains("image"))
                ).isEqualTo(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}