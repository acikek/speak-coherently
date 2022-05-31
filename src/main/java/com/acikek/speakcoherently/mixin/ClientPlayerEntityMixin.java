package com.acikek.speakcoherently.mixin;

import com.acikek.speakcoherently.effect.ModStatusEffects;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

	@Inject(method = "sendChatMessage", cancellable = true, at = @At("HEAD"))
	private void applySilence(String message, CallbackInfo ci) {
		if (((PlayerEntity) (Object) this).hasStatusEffect(ModStatusEffects.SILENCE)) {
			ci.cancel();
		}
	}
}
