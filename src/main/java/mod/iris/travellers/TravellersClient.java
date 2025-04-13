package mod.iris.travellers;

import mod.maxbogomol.fluffy_fur.FluffyFurClient;
import mod.maxbogomol.fluffy_fur.client.gui.screen.FluffyFurMod;
import mod.maxbogomol.fluffy_fur.client.gui.screen.FluffyFurPanorama;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.awt.*;
import java.util.Random;

import static mod.maxbogomol.fluffy_fur.FluffyFurClient.MOD_INSTANCE;

public class TravellersClient {

    private static FluffyFurPanorama FAIR_PANORAMA;
    public static Random random = new Random();


    public static class ClientOnly {
        public static void clientInit() {
            IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
            IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        }
    }

    public static void ClientSetup(final FMLClientSetupEvent event) {
        setupMenu();
    }


    public static void setupMenu() {
        MOD_INSTANCE = new FluffyFurMod(Travellers.MODID,Travellers.NAME,Travellers.VERSION).setDev("Iris").setDescription(Component.translatable("travellers.ffmenu_description"))
                .setNameColor(Color.GREEN)
                .setItem(new ItemStack(Items.NETHERITE_BLOCK));

        FAIR_PANORAMA = new FluffyFurPanorama(Travellers.MODID + ":fair", Component.translatable("panorama.travellers.fair"))
                .setMod(MOD_INSTANCE).setItem(new ItemStack(Items.NETHERITE_BLOCK))
                        .setLogo(new ResourceLocation(Travellers.MODID, "menu/title/goldsage.png"))
                                .setTexture(new ResourceLocation(Travellers.MODID,"panoramas/worldfair/panorama"));


        FluffyFurClient.registerPanorama(FAIR_PANORAMA);
        FluffyFurClient.registerMod(MOD_INSTANCE);


    }



}
