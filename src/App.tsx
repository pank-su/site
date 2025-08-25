import { ProfileCard } from "@/components/ProfileCard";
import { AboutCard } from "@/components/AboutCard";
import { AchievementsCarousel } from "@/components/AchievementsCarousel";

function App() {
  return (
    <div className="min-h-screen bg-background">
      <div className="container mx-auto px-4 py-8 max-w-6xl">
        {/* Header spacing */}
        <div className="h-10" />

        {/* Profile and About cards */}
        <div className="grid grid-cols-1 lg:grid-cols-2 gap-8 mb-8">
          <ProfileCard />
          <AboutCard />
        </div>

        {/* Achievements section */}
        <div className="mt-16">
          <AchievementsCarousel />
        </div>
      </div>
    </div>
  );
}

export default App;
