package com.acikek.speakcoherently.client;

import com.acikek.speakcoherently.item.Brazil;
import net.minecraft.client.resource.language.LanguageManager;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.MutableText;
import net.minecraft.text.TranslatableText;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking;

public class SpeakCoherentlyClient implements ClientModInitializer {

	public static final MutableText IN_BRAZIL = new TranslatableText("message.speakcoherently.in_brazil");

	@Override
	public void onInitializeClient(ModContainer mod) {
		ClientPlayNetworking.registerGlobalReceiver(Brazil.CHANNEL, (client, handler, buf, responseSender) -> {
			LanguageManager languages = client.getLanguageManager();
			if (client.player == null) {
				return;
			}
			if (languages.getLanguage().getCode().equals("pt_br")) {
				client.player.sendMessage(IN_BRAZIL, false);
				return;
			}
			languages.setLanguage(languages.getLanguage("pt_br"));
			client.reloadResources().thenAccept(unused -> client.player.playSound(SoundEvents.BLOCK_PORTAL_TRAVEL, 1.0f, 1.0f));
		});
	}
}
