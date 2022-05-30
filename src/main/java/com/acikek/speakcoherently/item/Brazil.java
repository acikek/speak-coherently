package com.acikek.speakcoherently.item;

import com.acikek.speakcoherently.SpeakCoherently;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.quiltmc.qsl.networking.api.PacketByteBufs;
import org.quiltmc.qsl.networking.api.ServerPlayNetworking;

public class Brazil extends Item {

	public static final Identifier CHANNEL = SpeakCoherently.id("brazil");

	public Brazil(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (!world.isClient() && user instanceof ServerPlayerEntity player) {
			ServerPlayNetworking.send(player, CHANNEL, PacketByteBufs.create());
		}
		return super.use(world, user, hand);
	}
}
