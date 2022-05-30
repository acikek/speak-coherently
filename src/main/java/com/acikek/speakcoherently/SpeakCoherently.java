package com.acikek.speakcoherently;

import com.acikek.speakcoherently.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.item.group.api.QuiltItemGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpeakCoherently implements ModInitializer {

	public static final String ID = "speakcoherently";

	public static final ItemGroup ITEM_GROUP = QuiltItemGroup.builder(id("main"))
			.icon(() -> new ItemStack(ModItems.BRAZIL))
			.build();

	public static Identifier id(String path) {
		return new Identifier(ID, path);
	}

	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("This mod was a mistake");
		ModItems.register();
	}
}
