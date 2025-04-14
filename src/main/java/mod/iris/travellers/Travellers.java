package mod.iris.travellers;

import com.mojang.logging.LogUtils;
import mod.iris.travellers.common.registry.TravellersItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(Travellers.MODID)
public class Travellers
{
    public static final String MODID = "travellers";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String NAME = "Travellers";
    public static final String VERSION = "alpha";
    public Travellers(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        TravellersItems.register(modEventBus);




        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);


        DistExecutor.unsafeCallWhenOn(Dist.CLIENT, () -> () -> {
            TravellersClient.ClientOnly.clientInit();
            return new Object();
        });

        modEventBus.addListener(TravellersClient::ClientSetup);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
           LOGGER.info("Hewwo from british Travellers! :3:3:3");
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.OP_BLOCKS) {
            event.accept(TravellersItems.PACT_FLESHY);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("mugging the integrated/dynamic server :3");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("hi esra");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
